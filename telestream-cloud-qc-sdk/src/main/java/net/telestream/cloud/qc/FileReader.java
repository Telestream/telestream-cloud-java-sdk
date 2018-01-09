package net.telestream.cloud.qc;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FileReader implements Runnable {
    private static final int MAX_OFFER_ATTEMPTS = 3;
    private File file;
    private List<Integer> parts;
    private Integer partSize;
    private Broker broker;
    private Iterator<Integer> partsIterator;
    private boolean verbose;

    public FileReader(File file, List<Integer> parts, Integer partSize, Broker broker, boolean verbose) {
        this.file = file;
        this.parts = parts;
        this.partSize = partSize;
        this.broker = broker;
        this.partsIterator = this.parts.iterator();
        this.verbose = verbose;
    }

    public FileReader(File file, List<Integer> parts, Integer partSize, Broker broker) {
        this(file, parts, partSize, broker, false);
    }

    public void run() {
        logMessage("Starting file reader.");
        int bytesRead;
        long totalRead = 0;
        int currentPart;
        long offset;
        RandomAccessFile raf;

        try {
            raf = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            logError("Failed to create a RandomAccessFile.");
            return;
        }

        while ((currentPart = getNextPart()) != -1 && broker.isOperating()) {
            offset = getOffset(currentPart);
            logMessage(String.format("Reading chunk at offset = %d", offset));

            try {
                raf.seek(offset);
            } catch (IOException e) {
                logError(String.format("Failed to seek to offset = %d.", offset));
                continue;
            }

            try {
                byte[] buffer = new byte[partSize];
                bytesRead = raf.read(buffer, 0, partSize);

                if (bytesRead == -1) {
                    logError(String.format("Failed to read part %d", currentPart));
                    continue;
                }

                totalRead += bytesRead;
                int offerAttempts = 0;
                boolean succeeded = false;
                while (offerAttempts++ < MAX_OFFER_ATTEMPTS) {
                    succeeded = broker.putChunk(new Chunk(currentPart, bytesRead, buffer));
                    if (succeeded) break;
                }
                if (succeeded) {
                    logMessage(String.format("Put %d bytes to the queue.", bytesRead));
                } else {
                    logError(String.format("Failed to put part %d to the queue.", currentPart));
                    break;
                }
            } catch (IOException e) {
                logError(String.format("Failed to read input file at offset = %d.", offset));
            } catch (InterruptedException e) {
                logError(String.format("Failed to put buffer read at offset = %d to the queue.", offset));
                break;
            }
        }

        logMessage("Shutting down the Broker.");
        broker.shutdown();

        logMessage(String.format("Total bytes read: %d.", totalRead));
        logMessage("Closing the RandomAccessFile.");

        try {
            raf.close();
        } catch (IOException e) {
            logError("Failed to close the RandomAccessFile.");
        }

        logMessage("File reader is going to sleep.");
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
