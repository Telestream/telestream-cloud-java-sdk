package net.telestream.cloud.tts;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Uploader {
    private enum Status {
        Created, Initialized, Uploading, Error, Uploaded, Aborted
    }
    private TtsApi apiClient;
    private String factoryId;
    private String filePath;
    private String profiles;
    private String location;
    private Integer partsCount;
    private Integer partSize;
    private int maxConnections;
    private ArrayList<ExtraFileMetadata> extraFilesMetadata;
    private Broker broker;
    private Thread reader;
    private ExecutorService uploadWorkers;
    private boolean verbose;
    private int numberOfRetries;
    private Status status = Status.Created;
    private Gson gson;

    public Uploader(TtsApi apiClient, String factoryId, String filePath, String profiles, HashMap<String,
            ArrayList<String>> extraFiles, int numberOfRetries, boolean verbose) {
        this.apiClient = apiClient;
        this.factoryId = factoryId;
        this.filePath = filePath;
        this.profiles = profiles;
        this.extraFilesMetadata = parseExtraFiles(extraFiles);
        this.verbose = verbose;
        this.numberOfRetries = numberOfRetries;
        this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    public Uploader(TtsApi apiClient, String factoryId, String filePath, String profiles, HashMap<String,
            ArrayList<String>> extraFiles) {
        this(apiClient, factoryId, filePath, profiles, extraFiles, 5, false);
    }

    public Uploader(TtsApi apiClient, String factoryId, String filePath) {
        this(apiClient, factoryId, filePath, null, null);
    }

    public Uploader(TtsApi apiClient) {
      this.apiClient = apiClient;
    }

    public void setup() {
        try {
            VideoUploadBody videoUploadBody = initializeVideoUploadBody();
            UploadSession us = apiClient.uploadVideo(factoryId, videoUploadBody);
            parseUploadSession(us);
            status = Status.Initialized;
        } catch (ApiException e) {
            logError("Failed to create an upload session");
            status = Status.Error;
        }
    }

    public void setup(String filePath, UploadSession uploadSession) {
      this.filePath = filePath;
      parseUploadSession(uploadSession);
      status = Status.Initialized;
    }

    public Status start() throws IllegalStateException {
        if (status == Status.Created) {
            throw new IllegalStateException("Not initialized.");
        } else if (status == Status.Uploading) {
            throw new IllegalStateException("Already started.");
        } else if (status == Status.Error) {
            throw new IllegalStateException("Error.");
        }
        status = Status.Uploading;

        ArrayList<Integer> parts = getListOfPartIds(partsCount);
        int connections = calculateMaxNumberOfConnections(parts.size());
        File inputFile = new File(filePath);

        initWorkers(inputFile, parts, partSize, connections);
        logMessage(String.format("Uploading %s.", inputFile.getName()));
        processFile(inputFile, partSize, connections, null);

        if (status == Status.Uploading) uploadExtraFiles();
        if (status == Status.Uploading) status = Status.Uploaded;

        return status;
    }

    public void abort() throws IllegalStateException {
        if (status != Status.Uploading) {
            throw new IllegalStateException("Upload finished.");
        }
        status = Status.Aborted;
        broker.shutdown();
    }

    public Status getStatus() {
        return status;
    }
    public String getVideoId() {
        return broker.getVideoId();
    }

    public String getMediaId() {
        return broker.getVideoId();
    }

    private void parseUploadSession(UploadSession uploadSession) {
        this.location = uploadSession.getLocation();
        this.partsCount = uploadSession.getParts();
        this.partSize = uploadSession.getPartSize();
        this.maxConnections = uploadSession.getMaxConnections();
        LinkedTreeMap<String, LinkedTreeMap<String, String>> extraFilesResponse = (LinkedTreeMap<String, LinkedTreeMap<String, String>>) uploadSession.getExtraFiles();
        if (extraFilesMetadata != null) {
            for (ExtraFileMetadata extraFileMetadata : extraFilesMetadata) {
                LinkedTreeMap<String, String> data = extraFilesResponse.get(extraFileMetadata.getTag());
                extraFileMetadata.setParts(Integer.valueOf(data.get("parts")));
                extraFileMetadata.setPartSize(Integer.valueOf(data.get("part_size")));
            }
        }
    }

    private void initWorkers(File file, ArrayList<Integer> parts, int partSize, int connections) {
        broker = new Broker(connections);
        reader = new Thread(new FileReader(file, parts, partSize, broker, verbose));
        uploadWorkers = Executors.newFixedThreadPool(connections);
    }

    private void uploadExtraFiles() {
        if (extraFilesMetadata == null) return;
        for (ExtraFileMetadata metadata : extraFilesMetadata) {
            int partSize = metadata.getPartSize();
            int partsCount = metadata.getParts();
            ArrayList<Integer> parts = getListOfPartIds(partsCount);
            int connections = calculateMaxNumberOfConnections(parts.size());
            File file = new File(metadata.getFilePath());

            initWorkers(file, parts, partSize, connections);
            logMessage(String.format("Uploading %s.", file.getName()));
            processFile(file, partSize, connections, metadata.getTag());

            if (status == Status.Error) break;
        }
    }

    private Status processFile(File file, int partSize, int connections, String tag) {
        for (int i = 0; i < numberOfRetries; i++) {
            perform(connections, tag);

            ArrayList<Integer> missingParts = getMissingParts(tag);
            if (missingParts == null) {
                status = Status.Error;
                logError("Failed to upload the input file.");
                break;
            }
            else if (missingParts.size() == 0) {
                logMessage("Successfully uploaded the input file.");
                break;
            } else {
                if (i < numberOfRetries - 1) {
                    logMessage(String.format("Retrying to upload parts: %s.", missingParts.toString()));
                    initWorkers(file, missingParts, partSize, connections);
                } else {
                    status = Status.Error;
                    break;
                }
            }
        }
        return status;
    }

    private int calculateMaxNumberOfConnections(int partsCount) {
        Integer availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 1) availableProcessors -= 1; // Reserve a core for a reader
        return Math.min(Math.min(maxConnections, availableProcessors), partsCount);
    }

    private void perform(int connections, String tag) {
        reader.start();

        for (int i = 0; i < connections; i++) {
            uploadWorkers.submit(new UploadWorker(location, broker, tag, verbose));
        }

        try {
            uploadWorkers.shutdown();
            while (!uploadWorkers.isTerminated()) {
                TimeUnit.SECONDS.sleep(1);
            }
            reader.join();
        } catch (InterruptedException e) {
            logError("Failed to upload the input file.");
            broker.shutdown();
        }
    }

    private ArrayList<Integer> getMissingParts(String tag) {
        try {
            CouchClient.HttpResponse response = new CouchClient(location).getMissingParts(tag);
            if (response.getStatus() == HttpURLConnection.HTTP_OK) {
                CouchClient.MissingPartsResponse missingPartsResponse = gson.fromJson(
                        response.getBody(), CouchClient.MissingPartsResponse.class
                );
                return missingPartsResponse.getMissingParts();
            }
        } catch (IOException e) {
            logError("Failed to fetch missing parts' ids.");
        }
        return null;
    }

    private void logMessage(String message) {
        if (verbose) {
            System.out.printf("[UPLOADER] %s\n", message);
        }
    }

    private void logError(String message) {
        if (verbose) {
            System.err.printf("[UPLOADER] %s\n", message);
        }
    }

    private ArrayList<Integer> getListOfPartIds(int partsCount) {
        ArrayList<Integer> parts = new ArrayList<>();
        for (int i = 0; i < partsCount; i++) parts.add(i);
        return parts;
    }

    private VideoUploadBody initializeVideoUploadBody() {
        VideoUploadBody videoUploadBody = new VideoUploadBody();

        setInputFileData(videoUploadBody);
        setExtraFilesData(videoUploadBody);

        return videoUploadBody;
    }

    private void setInputFileData(VideoUploadBody videoUploadBody) {
        File inputFile = new File(filePath);
        videoUploadBody.setFileSize(inputFile.length());
        videoUploadBody.setFileName(inputFile.getName());
        videoUploadBody.setProfiles(profiles);
        videoUploadBody.setMultiChunk(true);
    }

    private void setExtraFilesData(VideoUploadBody videoUploadBody) {
        if (extraFilesMetadata == null) {
            return;
        }
        ArrayList<ExtraFile> extraFiles = new ArrayList<>();
        for(ExtraFileMetadata extraFileMetadata : extraFilesMetadata) {
            File inputFile = new File(extraFileMetadata.getFilePath());
            ExtraFile extraFile = new ExtraFile();
            extraFile.setFileName(inputFile.getName());
            extraFile.setFileSize(inputFile.length());
            extraFile.setTag(extraFileMetadata.getTag());
            extraFiles.add(extraFile);
        }
        videoUploadBody.setExtraFiles(extraFiles);
    }

    private ArrayList<ExtraFileMetadata> parseExtraFiles(HashMap<String, ArrayList<String>> extraFiles) {
        if (extraFiles == null) {
            return null;
        }
        ArrayList<ExtraFileMetadata> extraFileMetadata = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : extraFiles.entrySet()) {
            String tag = entry.getKey();
            ArrayList<String> extraFilePaths = entry.getValue();
            if (extraFilePaths.size() == 1) {
                extraFileMetadata.add(new ExtraFileMetadata(tag, extraFilePaths.get(0)));
            } else {
                for (int i = 0; i < extraFilePaths.size(); i++) {
                    String indexedTag = String.format("%s.index-%d", tag, i);
                    extraFileMetadata.add(new ExtraFileMetadata(indexedTag, extraFilePaths.get(i)));
                }
            }
        }
        return extraFileMetadata;
    }

    private static class ExtraFileMetadata {
        String tag;
        String fileName;
        Long fileSize;
        Integer parts;
        Integer partSize;
        String filePath;

        ExtraFileMetadata(String tag, String filePath) {
            this.tag = tag;
            File file = new File(filePath);
            this.fileName = file.getName();
            this.fileSize = file.length();
            this.filePath = filePath;
        }

        String getTag() {
            return tag;
        }

        public String getFileName() {
            return fileName;
        }

        public Long getFileSize() {
            return fileSize;
        }

        Integer getParts() {
            return parts;
        }

        Integer getPartSize() {
            return partSize;
        }

        String getFilePath() {
            return filePath;
        }

        void setParts(Integer parts) {
            this.parts = parts;
        }

        void setPartSize(Integer partSize) {
            this.partSize = partSize;
        }
    }
}
