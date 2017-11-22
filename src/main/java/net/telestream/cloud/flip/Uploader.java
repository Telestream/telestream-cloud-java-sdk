package net.telestream.cloud.flip;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public class Uploader {
    private enum Status {
        Initialized, Uploading, Error, Uploaded, Aborted
    }
    private File inputFile;
    private String location;
    private Integer partsCount;
    private Integer partSize;
    private int maxConnections;
    private LinkedTreeMap<String, LinkedTreeMap<String, String>> extraFilesMetadata;
    private Broker broker;
    private Thread reader;
    private ExecutorService uploadWorkers;
    private boolean verbose;
    private int numberOfRetries;
    private Status status = Status.Initialized;
    private HashMap<String, File> extraFiles;
    private Gson gson;

    public Uploader(File file, HashMap<String, File> extraFiles, UploadSession session, int numberOfRetries, boolean verbose) {
        this.inputFile = file;
        this.location = session.getLocation();
        this.partsCount = session.getParts();
        this.partSize = session.getPartSize();
        this.maxConnections = session.getMaxConnections();
        this.extraFilesMetadata = (LinkedTreeMap<String, LinkedTreeMap<String, String>>) session.getExtraFiles();
        this.verbose = verbose;
        this.numberOfRetries = numberOfRetries;
        this.extraFiles = extraFiles;
        this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    public Uploader(File file, HashMap<String, File> extraFiles, UploadSession session) {
        this(file, extraFiles, session, 5, false);
    }

    public Status start() throws IllegalStateException {
        if (status != Status.Initialized) {
            throw new IllegalStateException("Already started.");
        }
        status = Status.Uploading;

        ArrayList<Integer> parts = getListOfPartIds(partsCount);
        int connections = calculateMaxNumberOfConnections(parts.size());

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

    private void initWorkers(File file, ArrayList<Integer> parts, int partSize, int connections) {
        broker = new Broker(connections);
        reader = new Thread(new FileReader(file, parts, partSize, broker, verbose));
        uploadWorkers = Executors.newFixedThreadPool(connections);
    }

    private void uploadExtraFiles() {
        if (extraFiles == null) return;
        for (HashMap.Entry<String, File> entry : extraFiles.entrySet()) {
            String tag = entry.getKey();
            File file = entry.getValue();
            LinkedTreeMap<String, String> metadata = extraFilesMetadata.get(tag);
            int partSize = Integer.valueOf(metadata.get("part_size"));
            int partsCount = Integer.valueOf(metadata.get("parts"));
            ArrayList<Integer> parts = getListOfPartIds(partsCount);
            int connections = calculateMaxNumberOfConnections(parts.size());

            initWorkers(file, parts, partSize, connections);
            logMessage(String.format("Uploading %s.", file.getName()));
            processFile(file, partSize, connections, tag);

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
        ArrayList<Integer> parts = new ArrayList<Integer>();
        for (int i = 0; i < partsCount; i++) parts.add(i);
        return parts;
    }
}
