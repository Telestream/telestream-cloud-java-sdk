package cloud;

import com.google.gson.Gson;
import objects.Video;
import utils.ChunkUploader;
import utils.GsonHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by maciejwitowski on 1/27/16.
 */
public class UploadSession {
    public enum UploadStatus {
        INITIALIZED, UPLOADING, ERROR, UPLOADED, ABORTED, INTERRUPTED
    }

    private static final String KEY_FILE_SIZE = "file_size";
    private static final String KEY_FILE_NAME = "file_name";
    private static final String KEY_PROFILES = "profiles";
    private static final String KEY_MULTI_CHUNK = "multi_chunk";
    private static final String KEY_EXTRA_FILES = "extra_files";
    private static final String DEFAULT_PROFILE = "h264";

    private static final String PATH_VIDEOS_UPLOAD = "/videos/upload";

    private String location;
    private int connections;

    private static class FileToUpload {

        private final File file;
        private final long fileSize;
        private final String fileName;

        private String tag;
        private int parts;
        private int part_size;
        private int missing_parts[];

        FileToUpload(File f) {
            if(null==f)
                throw new IllegalArgumentException("Given file object is null");

            file = f;
            fileSize = f.length();
            fileName = f.getName();
        }

        private void fillUploadParams(String t, int p, int psize) {
            tag = t;
            parts = p;
            part_size = psize;
            missing_parts = new int[parts];
            for(int i=0; i<parts; ++i) {
                missing_parts[i] = i;
            }
        }
    }

    private Map<String, FileToUpload> files_to_upload = new HashMap<>();

    private UploadStatus uploadStatus;
    private Video video; // TODO - assign after successful upload
    private List<String> errorMessages = new ArrayList<>();

    final private Gson gson = GsonHelper.get();

    public static UploadSession init(TelestreamCloudCredentials credentials, String factoryId,
                                     File file, Map<String, Object> params,
                                     Map<String, Object> extra_files, int connections) {

        FileToUpload main_file = new FileToUpload(file);

        UploadSession uploadSession = new UploadSession();

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put(KEY_MULTI_CHUNK, true);

        Map<String, Object> bodyParams = new HashMap<>();
        bodyParams.put(KEY_FILE_SIZE, main_file.fileSize);
        bodyParams.put(KEY_FILE_NAME, main_file.fileName);
        bodyParams.put(KEY_PROFILES, DEFAULT_PROFILE);
        bodyParams.put(KEY_EXTRA_FILES, uploadSession.parseExtraFiles(extra_files));

        if(params != null) bodyParams.putAll(params);

        String response = new TelestreamCloudRequest.Builder(credentials)
                .post()
                .apiPath(PATH_VIDEOS_UPLOAD)
                .factoryId(factoryId)
                .data(queryParams)
                .body(bodyParams)
                .signatureVer2(true)
                .build()
                .send();

        if(response != null) {
            VideoUploadResponse r = GsonHelper.get().fromJson(response, VideoUploadResponse.class);

            uploadSession.location = r.location;
            if(connections > 0 && connections < r.max_connections)
                uploadSession.connections = connections;
            else
                uploadSession.connections = r.max_connections;

            if(r.extra_files.size() != uploadSession.files_to_upload.size())
                throw new RuntimeException("Invalid response from server - extra file count doesn't match");

            for (Map.Entry<String, FileToUpload> pair : uploadSession.files_to_upload.entrySet()) {
                String tag = pair.getKey();
                FileToUpload f = pair.getValue();

                ExtraFileParams efp = r.extra_files.get(tag);
                if(null != efp)
                    f.fillUploadParams(tag, efp.parts, efp.part_size);
                else
                    throw new RuntimeException("Invalid response from server - extra file tags don't match");
            }

            // The main file does not have a tag, so we pass an empty string
            main_file.fillUploadParams("", r.parts, r.part_size);
            uploadSession.files_to_upload.put("", main_file);

            uploadSession.uploadStatus = UploadStatus.INITIALIZED;
            return uploadSession;
        } else
            throw new RuntimeException("Session init failed - no response from server");
    }

    public void start() throws Exception {
        if(uploadStatus != UploadStatus.INITIALIZED)
            throw new IllegalStateException("Already started");

        uploadStatus = UploadStatus.UPLOADING;
        uploadRemainingFiles();
        uploadStatus = files_to_upload.isEmpty() ? UploadStatus.UPLOADED : UploadStatus.ERROR;
    }

    private void uploadRemainingFiles() throws Exception {
        Iterator<Map.Entry<String, FileToUpload>> iter = files_to_upload.entrySet().iterator();
        while (iter.hasNext()) {
            FileToUpload f = iter.next().getValue();
            spawnUploadThreads(f);
            boolean success = checkRemoteStatus(f);
            if(success) {
                iter.remove(); // File uploaded - forget it and move on to the next one
            }
        }
    }

    class PartSender implements Runnable {
        private final FileToUpload ftu;
        private final int part_id;

        PartSender(FileToUpload f, int partId) {
            ftu = f;
            part_id = partId;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[ftu.part_size];
                long position = (long)ftu.part_size * (long)part_id;

                FileInputStream inputStream = new FileInputStream(ftu.file);
                inputStream.getChannel().position(position);
                int bytesRead = inputStream.read(buffer, 0, ftu.part_size);

                if(bytesRead <= 0) {
                    // EOF actually shouldn't happen - part_id must be wrong
                    return;
                }

                new ChunkUploader(location, part_id, ftu.tag, bytesRead).uploadChunk(buffer);

            } catch (IOException e) {
                appendErrorMessage(e.getMessage());
            }
        }
    }

    private void spawnUploadThreads(FileToUpload f) throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(connections);

        for(int i=0; i<f.missing_parts.length; ++i) {
            executorService.execute(new PartSender(f, f.missing_parts[i]));
        }

        executorService.shutdown();

        long completed = 0;
        while (!executorService.awaitTermination(10, TimeUnit.MINUTES)) {
            // check if there is any progress
            if(executorService.getCompletedTaskCount()>completed)
                completed = executorService.getCompletedTaskCount();
            else
                throw new RuntimeException("Upload process stuck on file " + f.fileName);
        }
    }

    private boolean checkRemoteStatus(FileToUpload f) throws IOException {
        URL url = new URL(location);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if(!f.tag.equals("")) // Need to tell which specific file we're asking about
            conn.setRequestProperty("X-Extra-File-Tag", f.tag);
        conn.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder respBody = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            respBody.append(output);
        }
        f.missing_parts = gson.fromJson(respBody.toString(), MissingChunksResponse.class).missing_parts;

        return 0 == f.missing_parts.length;
    }

    private List<Map<String, Object>> parseExtraFiles(Map<String, Object> input) {
        List<Map<String, Object>> result = new ArrayList<>();

        if(null==input)
            return result;

        for (Map.Entry<String, Object> pair : input.entrySet()) {
            String tag = pair.getKey();
            Object file = pair.getValue();
            if(file instanceof File[]) {
                File[] files = (File[])file;
                for(int i=0; i<files.length; ++i) {
                    String t = tag+".index-"+i;
                    FileToUpload f = new FileToUpload(files[i]);
                    result.add(buildExtraFileHashElement(t, f.fileName, f.fileSize));
                    files_to_upload.put(t, f);
                }
            } else if (file instanceof File) {
                FileToUpload f = new FileToUpload((File)file);
                result.add(buildExtraFileHashElement(tag, f.fileName, f.fileSize));
                files_to_upload.put(tag, f);
            } else {
                throw new IllegalArgumentException("Invalid type of extra file argument(s)");
            }
        }
        return result;
    }

    private static Map<String, Object> buildExtraFileHashElement(String tag, String fname, long fsize) {
        Map<String, Object> extra_file = new HashMap<>();
        extra_file.put("tag", tag);
        extra_file.put("file_name", fname);
        extra_file.put("file_size", fsize);
        return extra_file;
    }

    public void resume() throws Exception {
        if(uploadStatus == UploadStatus.UPLOADED)
            throw new IllegalStateException("Already uploaded");

        uploadRemainingFiles();
        uploadStatus = files_to_upload.isEmpty() ? UploadStatus.UPLOADED : UploadStatus.ERROR;
    }

    public boolean abort() throws IOException {
        if(uploadStatus == UploadStatus.UPLOADED)
            throw new IllegalStateException("Already uploaded");

        uploadStatus = UploadStatus.ABORTED;

        URL url = new URL(location);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("DELETE");
        httpConn.connect();
        int responseCode = httpConn.getResponseCode();
        return responseCode == 200;
    }

    public Video getVideo() {
        return video;
    }
    
    synchronized private void appendErrorMessage(String err) {
        errorMessages.add(err);
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public UploadStatus getUploadStatus() {
        return uploadStatus;
    }

    private static class ExtraFileParams {
        private String name;
        private String tag;
        private int parts;
        private int part_size;
    }

    private static class VideoUploadResponse {
        private String id;
        private String location;
        private int parts;
        private int part_size;
        private int max_connections;
        private Map<String, ExtraFileParams> extra_files;
    }
    
    private static class MissingChunksResponse {
        private int missing_parts[];
    }
}
