package net.telestream.cloud;

public final class TelestreamCloudCredentials {

    private static final String DEFAULT_API_HOST = "api-gce.pandastream.com";
    private static final String DEFAULT_API_VERSION = "3.0";
    private static final int DEFAULT_API_PORT = 443;

    private final String accessKey;
    private final String secretKey;

    private String apiHost;
    private String apiVersion;
    private int apiPort;

    public TelestreamCloudCredentials(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.apiHost = DEFAULT_API_HOST;
        this.apiPort = DEFAULT_API_PORT;
        this.apiVersion = DEFAULT_API_VERSION;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public int getApiPort() {
        return apiPort;
    }

    public void setApiPort(int apiPort) {
        this.apiPort = apiPort;
    }

    public boolean isDefaultApiPort() {
        return this.apiPort == DEFAULT_API_PORT;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
