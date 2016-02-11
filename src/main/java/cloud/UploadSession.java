package cloud;

import com.google.gson.Gson;
import objects.Video;
import services.VideoService;
import utils.ChunkUploader;
import utils.GsonHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
    private static final String DEFAULT_PROFILE = "h264";

    private static final String PATH_VIDEOS_UPLOAD = "/videos/upload";

    private final File file;
    private long fileSize;

    private String location;

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
        }

        uploadSession.uploadStatus = UploadStatus.INITIALIZED;
        return uploadSession;
    }

    public void start() throws IOException {
        startFromPosition(0);
    }

    private void startFromPosition(int position) throws IOException {
        if(uploadStatus != UploadStatus.INITIALIZED)
            throw new IllegalStateException("Already started");

        uploadStatus = UploadStatus.UPLOADING;

        byte[] buffer = new byte[CHUNK_SIZE];
        int counter = 0;
        int index;
        int bytesRead;

        try {
            FileInputStream inputStream = new FileInputStream(file);

            while ((bytesRead = inputStream.read(buffer, position, CHUNK_SIZE)) != -1) {
                index = counter * CHUNK_SIZE;

                if(counter == 2) break;

                ChunkUploader.HttpResponse response = new ChunkUploader(location, position + index,
                        position + index + CHUNK_SIZE-1, fileSize, bytesRead).uploadChunk(buffer);

                int responseStatus = response.getStatus();
                if (responseStatus == HttpURLConnection.HTTP_OK) {
                    uploadStatus = UploadStatus.UPLOADED;
                    this.video = gson.fromJson(response.getBody(), VideoService.TYPE_VIDEO);
                } else if (responseStatus != HttpURLConnection.HTTP_NO_CONTENT) {
                    this.uploadStatus = UploadStatus.ERROR;
                    break;
                }
                counter++;
            }
        } catch (IOException e) {
            this.uploadStatus = UploadStatus.ERROR;
            this.errorMessage = e.getMessage();
            throw e;
        }
    }

    public void resume() throws IOException {
        if(uploadStatus == UploadStatus.UPLOADED)
            throw new IllegalStateException("Already uploaded");

        URL url = new URL(location);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("Content-Type", "application/octet-stream");
        httpConn.setUseCaches(false);
        httpConn.setRequestProperty("Content-Range", "bytes */" + fileSize);
        httpConn.setRequestProperty("Content-Length", "0");
        httpConn.setRequestProperty("Content-Transfer-Encoding", "binary");

        httpConn.connect();
        String rangeHeader = httpConn.getHeaderField("Range");
        if(rangeHeader != null) {
            String rangeEnd = rangeHeader.split("-")[1];
            uploadStatus = UploadStatus.INITIALIZED;
            startFromPosition(Integer.valueOf(rangeEnd));
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
    }
}
