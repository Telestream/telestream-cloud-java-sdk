package net.telestream.cloud.flip;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker {
    private ArrayBlockingQueue<Chunk> queue;
    private boolean operating = true;
    private int pollTimeout = 1;
    private int offerTimeout = 5;

    public Broker(int queueSize) {
        this.queue = new ArrayBlockingQueue<Chunk>(queueSize);
    }

    public Chunk getChunk() throws InterruptedException {
        return queue.poll(pollTimeout, TimeUnit.SECONDS);
    }

    public boolean putChunk(Chunk chunk) throws InterruptedException {
        return queue.offer(chunk, offerTimeout, TimeUnit.SECONDS);
    }

    public void setPollTimeout(int pollTimeout) {
        this.pollTimeout = pollTimeout;
    }

    public void setOfferTimeout(int offerTimeout) {
        this.offerTimeout = offerTimeout;
    }

    public boolean isOperating() {
        return operating;
    }

    public void shutdown() {
        this.operating = false;
    }

    public int queueSize() {
        return queue.size();
    }
}
