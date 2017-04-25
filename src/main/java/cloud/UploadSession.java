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
    private static final String DEFAULT_PROFILE = "h264";

    private static final String PATH_VIDEOS_UPLOAD = "/videos/upload";

    private final File file;
    private long fileSize;

    private String location;
    private int parts;
    private int part_size;
    private int max_connections;
    
    private int missing_parts[];

    public UploadStatus uploadStatus;
    private Video video; // TODO - assign after successful upload
    private List<String> errorMessages;

    final private Gson gson = GsonHelper.get();

    public UploadSession(File file) {
        if(file == null)
            throw new IllegalArgumentException("File must not be null");

        this.file = file;
    }

    public static UploadSession init(TelestreamCloudCredentials credentials, String factoryId,
                                     File file, Map<String, Object> params) {
        UploadSession uploadSession = new UploadSession(file);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put(KEY_MULTI_CHUNK, true);
        
        Map<String, Object> bodyParams = new HashMap<>();
        long fileSize = file.length();
        uploadSession.fileSize = fileSize;
        bodyParams.put(KEY_FILE_SIZE, fileSize);
        bodyParams.put(KEY_FILE_NAME, file.getName());
        bodyParams.put(KEY_PROFILES, DEFAULT_PROFILE);

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
            uploadSession.location = GsonHelper.get().fromJson(response, VideoUploadResponse.class).location;
            uploadSession.parts = GsonHelper.get().fromJson(response, VideoUploadResponse.class).parts;
            uploadSession.part_size = GsonHelper.get().fromJson(response, VideoUploadResponse.class).part_size;
            uploadSession.max_connections = GsonHelper.get().fromJson(response, VideoUploadResponse.class).max_connections;
        }
        
        uploadSession.missing_parts = new int[uploadSession.parts];
        for(int i=0; i<uploadSession.parts; ++i) {
            uploadSession.missing_parts[i] = i;
        }

        uploadSession.uploadStatus = UploadStatus.INITIALIZED;
        return uploadSession;
    }

    public void start() throws Exception {
        if(uploadStatus != UploadStatus.INITIALIZED)
            throw new IllegalStateException("Already started");

        uploadStatus = UploadStatus.UPLOADING;

        spawnUploadThreads();

        checkAndUpdateStatus();
    }

    class PartSender implements Runnable
    {
        private final int part_id;

        PartSender(int partId) {
            part_id = partId;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[part_size];
                long position = (long)part_size * (long)part_id;

                FileInputStream inputStream = new FileInputStream(file);
                inputStream.getChannel().position(position);
                int bytesRead = inputStream.read(buffer, 0, part_size);

                if(bytesRead <= 0) {
                    // EOF actually shouldn't happen - part_id must be wrong
                    return;
                }

                new ChunkUploader(location, part_id, fileSize, bytesRead).uploadChunk(buffer);

            } catch (IOException e) {
                appendErrorMessage(e.getMessage());
            }
        }
    }

    private void spawnUploadThreads() throws Exception {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(max_connections);

        for(int i=0; i<missing_parts.length; ++i) {
            executorService.execute(new PartSender(missing_parts[i]));
        }

        executorService.shutdown();
        
        long completed = 0;
        while (!executorService.awaitTermination(10, TimeUnit.MINUTES)) {
            // check if there is any progress
            if(executorService.getCompletedTaskCount()>completed)
                completed = executorService.getCompletedTaskCount();
            else
                throw new RuntimeException("Upload process stuck");
        }
    }

    private void checkAndUpdateStatus() throws IOException {
        URL url = new URL(location);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder respBody = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            respBody.append(output);
        }
        missing_parts = gson.fromJson(respBody.toString(), MissingChunksResponse.class).missing_parts;

        uploadStatus = (missing_parts.length==0) ? UploadStatus.UPLOADED : UploadStatus.ERROR;
    }

    public void resume() throws Exception {
        if(uploadStatus == UploadStatus.UPLOADED)
            throw new IllegalStateException("Already uploaded");

        spawnUploadThreads();

        checkAndUpdateStatus();
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

    private static class VideoUploadResponse {
        private String id;
        private String location;
        private int parts;
        private int part_size;
        private int max_connections;
    }
    
    private static class MissingChunksResponse {
        private int missing_parts[];
    }
}
