package net.telestream.cloud.tts;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.UUID;

public class UploadWorker implements Runnable {
    private String upstream;
    private Broker broker;
    private String id;
    private String tag;
    private boolean verbose;

    public UploadWorker(String upstream, Broker broker, String tag, boolean verbose) {
        this.upstream = upstream;
        this.broker = broker;
        this.id = UUID.randomUUID().toString();
        this.tag = tag;
        this.verbose = verbose;
    }

    public UploadWorker(String upstream, Broker broker, String tag) {
        this(upstream, broker, tag,false);
    }

    public void run() {
        try {
            logMessage("Initialized worker.");
            while (broker.isOperating() || broker.queueSize() > 0) {
                Chunk chunk;
                chunk = broker.getChunk();
                if (chunk != null) {
                    processChunk(chunk);
                }
            }
            logMessage("Worker is going to sleep.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processChunk(Chunk chunk) throws InterruptedException {
        if (chunk != null) {
            logMessage(String.format("Worker fetched %d bytes.", chunk.getContentLength()));
            try {
                CouchClient.HttpResponse response = new CouchClient(upstream)
                        .uploadChunk(chunk.getId(), chunk.getContentLength(), chunk.getContent(), tag);
                int responseStatus = response.getStatus();
                if (responseStatus == HttpURLConnection.HTTP_OK) {
                    logMessage(String.format("Uploaded chunk %d.", chunk.getId()));
                    if (response.getBody() != null) {
                        storeVideoId(response.getBody());
                    }
                } else {
                    logError(String.format("Failed to upload chunk %d.", chunk.getId()));
                }
            } catch (IOException e) {
                logError(String.format("Failed to upload chunk %d.", chunk.getId()));
            }
        }
    }

    private void logMessage(String message) {
        if (verbose) {
            System.out.printf("[WORKER][ID=%s] %s\n", id, message);
        }
    }

    private void logError(String message) {
        if (verbose) {
            System.err.printf("[WORKER][ID=%s] %s\n", id, message);
        }
    }

    private void storeVideoId(String responseBody) {
        if (broker.getVideoId() != null) return;
        String videoId = new GsonBuilder().create().fromJson(responseBody, VideoIdResponse.class).getId();
        broker.setVideoId(videoId);
    }

    private static class VideoIdResponse {
        public String id;

        public String getId() {
            return id;
        }
    }
}
