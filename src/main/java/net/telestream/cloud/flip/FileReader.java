package net.telestream.cloud.flip;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileReader extends Thread {
    private static final int QUEUE_OFFER_TIMEOUT = 15;
    private File file;
    private List<Integer> parts;
    private Integer partSize;
    private BlockingQueue<Chunk> queue;
    private Iterator<Integer> partsIterator;
    private volatile boolean running = true;
    private boolean verbose;

    public FileReader(File file, List<Integer> parts, Integer partSize, BlockingQueue<Chunk> queue, boolean verbose) {
        this.file = file;
        this.parts = parts;
        this.partSize = partSize;
        this.queue = queue;
        this.partsIterator = this.parts.iterator();
        this.verbose = verbose;
    }

    public FileReader(File file, List<Integer> parts, Integer partSize, BlockingQueue<Chunk> queue) {
        this(file, parts, partSize, queue, false);
    }

    public void run() {
        logMessage("Starting file reader..");
        byte[] buffer = new byte[partSize];
        int bytesRead;
        int currentPart;

        RandomAccessFile raf;

        try {
            raf = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            logError("Failed to create a RandomAccessFile.");
            return;
        }

        while ((currentPart = getNextPart()) != -1 && running) {
            logMessage(String.format("Reading chunk at offset = %d", getOffset(currentPart)));
            try {
                raf.seek(getOffset(currentPart));
            } catch (IOException e) {
                logError(String.format("Failed to seek to offset = %d.", getOffset(currentPart)));
                continue;
            }

            try {
                bytesRead = raf.read(buffer, 0, partSize);
                if (bytesRead != -1) {
                    if (
                        queue.offer(new Chunk(currentPart, bytesRead, buffer), QUEUE_OFFER_TIMEOUT, TimeUnit.SECONDS)
                    ) {
                        logMessage(String.format("Put %d bytes to the queue", bytesRead));
                    } else {
                        logError(String.format("Failed to put part %d to the queue", currentPart));
                    }
                }
            } catch (IOException e) {
                logError(String.format("Failed to read input file at offset = %d.", getOffset(currentPart)));

            } catch (InterruptedException e) {
                logError(String.format("Failed to put buffer read at offset = %d to the queue.", getOffset(currentPart)));
            }
        }

        logMessage(String.format("Closing the RandomAccessFile."));
        try {
            raf.close();
        } catch (IOException e) {
            logError(String.format("Failed to close the RandomAccessFile."));
        }

        logMessage(String.format("File reader is going to sleep."));
    }

    public void shutdown() {
        this.running = false;
    }

    private int getNextPart() {
        if (partsIterator.hasNext()) {
            return partsIterator.next();
        } else {
            return -1;
        }
    }

    private long getOffset(int part) {
        return part * partSize;
    }

    private void logMessage(String message) {
        if (verbose) {
            System.out.printf("[FILE READER] %s\n", message);
        }
    }

    private void logError(String message) {
        if (verbose) {
            System.err.printf("[FILE READER] %s\n", message);
        }
    }
}
