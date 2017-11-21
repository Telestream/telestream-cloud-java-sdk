package net.telestream.cloud.flip;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class Uploader {
    private enum Status {
        Initialized, Uploading, Error, Uploaded
    }
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
    private Status status = Status.Initialized;
    private  ArrayList<Integer> parts;

    public Uploader(File file, UploadSession session, int numberOfRetries, boolean verbose) {
        this.file = file;
        this.location = session.getLocation();
        this.partsCount = session.getParts();
        this.partSize = session.getPartSize();
        this.maxConnections = session.getMaxConnections();
//        this.extraFiles = (HashMap<String, HashMap<String, String>>) session.getExtraFiles();
        this.verbose = verbose;
        this.numberOfRetries = numberOfRetries;
        this.parts = new ArrayList<Integer>();
        for (int i = 0; i < partsCount; i++) parts.add(i);
    }

    public Uploader(File file, UploadSession session) {
        this(file, session, 5, false);
    }

    public void init() {
        calculateMaxNumberOfConnections();
        broker = new Broker(maxConnections);
        reader = new Thread(new FileReader(file, parts, partSize, broker, verbose));
        uploadWorkers = Executors.newFixedThreadPool(maxConnections);
    }

    public void start() throws InterruptedException {
        status = Status.Uploading;
        for (int i = 0; i < numberOfRetries; i++) {
            uploadFile();
            ArrayList<Integer> missingParts = getMissingParts();
            if (missingParts == null) {
                status = Status.Error;
                logError("Failed to upload the input file");
                break;
            }
            else if (missingParts.size() == 0) {
                logMessage("Successfully uploaded the input file");
                status = Status.Uploaded;
                break;
            } else {
                if (i < numberOfRetries - 1) {
                    logMessage(String.format("Retrying to upload parts: %s", missingParts.toString()));
                    partsCount = missingParts.size();
                    parts = missingParts;
                    init();
                } else {
                    status = Status.Error;
                    break;
                }
            }
        }
    }

    public Status getStatus() {
        return status;
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
            logError("Failed to upload the file");
            broker.shutdown();
        }
    }

    private ArrayList<Integer> getMissingParts() {
        try {
            CouchClient.HttpResponse response = new CouchClient(location).getMissingParts();
            if (response.getStatus() == HttpURLConnection.HTTP_OK) {
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
                CouchClient.MissingPartsResponse missingPartsResponse = gson.fromJson(
                        response.getBody(), CouchClient.MissingPartsResponse.class
                );
                return missingPartsResponse.getMissingParts();
            }
        } catch (IOException e) {
            logError("Failed to fetch missing parts' ids");
        }
        return null;
    }

    private void logMessage(String message) {
        if (verbose) {
            System.out.printf("[UPLOADER] %s\n", message);
        }
    }

    private void logError(String message) {
        if (verbose) {
            System.err.printf("[UPLOADER] %s\n", message);
        }
    }
}
