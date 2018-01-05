package net.telestream.cloud.qc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker {
    private ArrayBlockingQueue<Chunk> queue;
    private volatile boolean operating = true;
    private int pollTimeout = 1;
    private int offerTimeout = 5;
    private volatile String videoId;

    Broker(int queueSize) {
        this.queue = new ArrayBlockingQueue<>(queueSize);
    }

    Chunk getChunk() throws InterruptedException {
        return queue.poll(pollTimeout, TimeUnit.SECONDS);
    }

    boolean putChunk(Chunk chunk) throws InterruptedException {
        return queue.offer(chunk, offerTimeout, TimeUnit.SECONDS);
    }

    public void setPollTimeout(int pollTimeout) {
        this.pollTimeout = pollTimeout;
    }

    public void setOfferTimeout(int offerTimeout) {
        this.offerTimeout = offerTimeout;
    }

    boolean isOperating() {
        return operating;
    }

    void shutdown() {
        this.operating = false;
    }

    int queueSize() {
        return queue.size();
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }
}
