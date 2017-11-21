package net.telestream.cloud.flip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class Uploader {
    private File file;
    private String location;
    private Integer partsCount;
    private Integer partSize;
    private int maxConnections;
    private HashMap extraFiles;
    private Broker broker;
    private Thread reader;
    private ExecutorService uploadWorkers;
    private boolean verbose;
    private int numberOfRetries;

    public Uploader(File file, UploadSession session, int numberOfRetries, boolean verbose) {
        this.file = file;
        this.location = session.getLocation();
        this.partsCount = session.getParts();
        this.partSize = session.getPartSize();
        this.maxConnections = session.getMaxConnections();
//        this.extraFiles = (HashMap<String, HashMap<String, String>>) session.getExtraFiles();
        this.verbose = verbose;
        this.numberOfRetries = numberOfRetries;
    }

    public Uploader(File file, UploadSession session) {
        this(file, session, 5, false);
    }

    public void init() {
        calculateMaxNumberOfConnections();

        broker = new Broker(maxConnections);

        ArrayList<Integer> parts = new ArrayList<Integer>();
        for (int i = 0; i < partsCount; i++) parts.add(i);

        reader = new Thread(new FileReader(file, parts, partSize, broker, verbose));
        uploadWorkers = Executors.newFixedThreadPool(maxConnections);
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < numberOfRetries; i++) {
            uploadFile();
            List<Integer> missingParts = getMissingParts();
            if (missingParts.size() == 0) break;
        }
    }

    private int calculateMaxNumberOfConnections() {
        Integer availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 1) availableProcessors -= 1; // Reserve a core for a reader
        maxConnections = Math.min(Math.min(maxConnections, availableProcessors), partsCount);
        return maxConnections;
    }

    private void uploadFile() {
        reader.start();

        for (int i = 0; i < maxConnections; i++) {
            uploadWorkers.submit(new UploadWorker(location, broker, verbose));
        }

        try {
            uploadWorkers.shutdown();
            while (!uploadWorkers.isTerminated()) {
                TimeUnit.SECONDS.sleep(1);
            }
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> getMissingParts() {
        return new ArrayList<Integer>();
    }
}
