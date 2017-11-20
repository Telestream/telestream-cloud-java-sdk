package net.telestream.cloud.flip;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class UploadWorker implements Runnable {
    private static final int ATTEMPTS_TO_REACH_QUEUE = 20;
    private BlockingQueue<Chunk> queue;
    private String id;
    private boolean verbose;

    public UploadWorker(BlockingQueue<Chunk> queue, boolean verbose) {
        this.queue = queue;
        this.id = UUID.randomUUID().toString();
        this.verbose = verbose;
    }

    public UploadWorker(BlockingQueue<Chunk> queue) {
        this(queue, false);
    }

    public void run() {
        try {
            logMessage("Initialized worker.");
            int attempts = 0;
            while (queue.isEmpty() && attempts++ < ATTEMPTS_TO_REACH_QUEUE) Thread.sleep(1000);
            logMessage("Starting processing.");
            Chunk chunk;
            while (!queue.isEmpty()) {
                chunk = queue.poll(5, TimeUnit.SECONDS);
                if (chunk != null) {
                    logMessage(String.format("Worker fetched %d bytes.", chunk.getContentLength()));
                    Thread.sleep(1000);
                }
            }
            logMessage("Worker is going to sleep.");
        } catch (InterruptedException e) {
            e.printStackTrace();
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
