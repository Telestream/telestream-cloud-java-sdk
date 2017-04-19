package cloud;

import com.google.gson.Gson;
import objects.Video;
import services.VideoService;
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

/**
 * Created by maciejwitowski on 1/27/16.
 */
public class UploadSession {
    public enum UploadStatus {
        INITIALIZED, UPLOADING, ERROR, UPLOADED, ABORTED, INTERRUPTED
    }

    private static final int CHUNK_SIZE = 5 * 1024 * 1024;

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
    private Video video;
    private String errorMessage;

    private Gson gson = GsonHelper.get();

    public UploadSession(File file) {
        if(file == null)
            throw new IllegalArgumentException("File must not be null");

        this.file = file;
    }

    public static UploadSession init(TelestreamCloudCredentials credentials, String factoryId,
                                     File file, Map<String, Object> params) {
        UploadSession uploadSession = new UploadSession(file);

        Map<String, Object> uploadParams = new HashMap<>();

        long fileSize = file.length();
        uploadSession.fileSize = fileSize;
        uploadParams.put(KEY_FILE_SIZE, fileSize);
        uploadParams.put(KEY_FILE_NAME, file.getName());
        uploadParams.put(KEY_PROFILES, DEFAULT_PROFILE);
        uploadParams.put(KEY_MULTI_CHUNK, true);

        if(params != null) uploadParams.putAll(params);

        String response = new TelestreamCloudRequest.Builder(credentials)
                .post()
                .apiPath(PATH_VIDEOS_UPLOAD)
                .factoryId(factoryId)
                .data(uploadParams)
                .build()
                .send();

        if(response != null) {
            uploadSession.location = GsonHelper.get().fromJson(response, VideoUploadResponse.class).location;
            uploadSession.parts = GsonHelper.get().fromJson(response, VideoUploadResponse.class).parts;
            uploadSession.part_size = GsonHelper.get().fromJson(response, VideoUploadResponse.class).part_size;
            uploadSession.max_connections = GsonHelper.get().fromJson(response, VideoUploadResponse.class).max_connections;
        }

        uploadSession.uploadStatus = UploadStatus.INITIALIZED;
        return uploadSession;
    }

    public void start() throws IOException {
        if(uploadStatus != UploadStatus.INITIALIZED)
            throw new IllegalStateException("Already started");

        uploadStatus = UploadStatus.UPLOADING;

        for(int i = 0; i<parts; ++i) {
            sendPart(i);
        }

        while(isRemoteStatusOk()==false)
        {
            retry();
        }
    }

    private void sendPart(int part_id) throws IOException {
        try {
            byte[] buffer = new byte[part_size];
            long position = (long)part_size * (long)part_id;

            FileInputStream inputStream = new FileInputStream(file);
            inputStream.getChannel().position(position);
            int bytesRead = inputStream.read(buffer, 0, part_size);

            if(bytesRead == -1) {
                // EOF actually shouldn't happen - part_id must be wrong
                uploadStatus = UploadStatus.ERROR;
                return;
            }

            ChunkUploader.HttpResponse response = new ChunkUploader(location, part_id,
                    fileSize, bytesRead).uploadChunk(buffer);

            if(response.getStatus()!=HttpURLConnection.HTTP_OK) {
                uploadStatus = UploadStatus.ERROR;
            }
        } catch (IOException e) {
            this.uploadStatus = UploadStatus.ERROR;
            this.errorMessage = e.getMessage();
            throw e;
        }
    }
    
    private boolean isRemoteStatusOk() throws IOException {
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
        missing_parts = GsonHelper.get().fromJson(respBody.toString(), MissingChunksResponse.class).missing_parts;

        if(missing_parts.length==0) {
            uploadStatus = UploadStatus.UPLOADED;
            return true;
        }

        return false;
    }

    private void retry() throws IOException {
        for(int i=0; i<missing_parts.length; ++i)
        {
            sendPart(missing_parts[i]);
        }
    }

    public void resume() throws IOException {
        if(uploadStatus == UploadStatus.UPLOADED)
            throw new IllegalStateException("Already uploaded");
        
        if(isRemoteStatusOk()==false)
        {
            retry();
        }
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

    public String getErrorMessage() {
        return errorMessage;
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
        private String extra_files;
    }
    
    private static class MissingChunksResponse {
        private int missing_parts[];
    }
}
