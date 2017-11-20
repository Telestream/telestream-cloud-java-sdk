package net.telestream.cloud.flip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public class Uploader {
    private String path;
    private String location;
    private Integer partsCount;
    private Integer partSize;
    private int maxConnections;
    private HashMap extraFiles;
    private BlockingQueue<Chunk> queue;
    private FileReader reader;
    private ExecutorService uploadWorkers;

    public Uploader(String path, UploadSession session) {
        this.path = path;
        this.location = session.getLocation();
        this.partsCount = session.getParts();
        this.partSize = session.getPartSize();
        this.maxConnections = session.getMaxConnections();
//        this.extraFiles = (HashMap<String, HashMap<String, String>>) session.getExtraFiles();
    }

    public void init() throws FileNotFoundException{
        File file = new File(path);

        if(!file.exists()) {
            throw new FileNotFoundException(path);
        }

        calculateMaxNumberOfConnections();

        queue = new ArrayBlockingQueue<Chunk>(maxConnections);

        ArrayList<Integer> parts = new ArrayList<Integer>();
        for (int i = 0; i < partsCount; i++) parts.add(i);

        reader = new FileReader(file, parts, partSize, queue, true);
        uploadWorkers = Executors.newFixedThreadPool(maxConnections);
    }

    public void start() throws InterruptedException {
        reader.start();

        for (int i = 0; i < maxConnections; i++) {
            uploadWorkers.submit(new UploadWorker(queue, true));
        }

        try {
            uploadWorkers.shutdown();
            while (!uploadWorkers.isTerminated()) {
                TimeUnit.SECONDS.sleep(1);
            }
            if (reader.isAlive()) {
                reader.shutdown();
            }
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int calculateMaxNumberOfConnections() {
        Integer availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 1) availableProcessors -= 1; // Reserve a core for a reader
        maxConnections = Math.min(Math.min(maxConnections, availableProcessors), partsCount);
        return maxConnections;
    }
}
