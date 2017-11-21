package net.telestream.cloud.flip;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class UploadWorker implements Runnable {
    private String upstream;
    private Broker broker;
    private String id;
    private boolean verbose;

    public UploadWorker(String upstream, Broker broker, boolean verbose) {
        this.upstream = upstream;
        this.broker = broker;
        this.id = UUID.randomUUID().toString();
        this.verbose = verbose;
    }

    public UploadWorker(String upstream, Broker broker) {
        this(upstream, broker, false);
    }

    public void run() {
        try {
            logMessage("Initialized worker.");
            while (broker.isOperating() || broker.queueSize() > 0) {
                Chunk chunk;
                chunk = broker.getChunk();
                if (chunk != null) {
                    uploadChunk(chunk);
                }
            }
            logMessage("Worker is going to sleep.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void uploadChunk(Chunk chunk) throws InterruptedException {
        if (chunk != null) {
            logMessage(String.format("Worker fetched %d bytes.", chunk.getContentLength()));
            try {
                ChunkUploader.HttpResponse response = new ChunkUploader(
                        upstream, chunk.getId(), chunk.getContentLength()
                ).uploadChunk(chunk.getContent());
                int responseStatus = response.getStatus();
                if (responseStatus == HttpURLConnection.HTTP_OK) {
                    logMessage("OK");
                } else if (responseStatus != HttpURLConnection.HTTP_NO_CONTENT) {
                    logError("NO CONTENT");
                } else {
                    logError("ERROR");
                    logError(response.getBody());
                }

            } catch (IOException e) {
                e.printStackTrace();
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

}
