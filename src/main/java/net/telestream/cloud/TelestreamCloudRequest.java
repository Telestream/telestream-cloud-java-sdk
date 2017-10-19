package net.telestream.cloud;

import com.google.gson.reflect.TypeToken;
import net.telestream.cloud.utils.GsonHelper;
import net.telestream.cloud.utils.MultipartUploader;
import net.telestream.cloud.utils.Utils;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/19/16.
 */
public class TelestreamCloudRequest {
    private enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    private enum HttpProtocol {
        HTTP, HTTPS
    }

    private static final String KEY_FILE = "file";

    final HttpMethod httpMethod;
    final String path;
    final TelestreamCloudCredentials credentials;
    final String factoryId;
    final Map<String, Object> data;
    final String timestamp;
    final Boolean json;

    public TelestreamCloudRequest(Builder builder) {
        this.httpMethod = builder.httpMethod;
        this.path = builder.apiPath;
        this.credentials = builder.credentials;
        this.factoryId = builder.factoryId;
        this.data = builder.data;
        this.timestamp = builder.timestamp;
        this.json = builder.json;
    }

    public String send() {
        try {
           return sendRequestForResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sendRequestForResult() throws IOException {
        URL url = buildRequestUrl();

        if (json) {
            return getJsonResponse(url);
        } else {
            return isUploadingFile() ? getMultipartResponse(url) : getResponse(url);
        }
    }

    private URL buildRequestUrl() throws IOException {
        return new URL(apiProtocol().name(), credentials.getApiHost(), apiPort(), pathWithParams());
    }

    private boolean isUploadingFile() {
        return httpMethod.equals(HttpMethod.POST) && data!=null && data.containsKey(KEY_FILE);
    }

    private String getMultipartResponse(URL url) throws IOException {
        MultipartUploader multipart = new MultipartUploader(url.toString(), Utils.UTF_8);
        multipart.addFilePart(KEY_FILE, (File) data.get(KEY_FILE));
        return multipart.finish().get(0);
    }

    private String getResponse(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(httpMethod.name());
        conn.connect();
        InputStream is = conn.getInputStream();
        return Utils.readInput(is);
    }

    private String getJsonResponse(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(httpMethod.name());
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(getJsonBody().getBytes(StandardCharsets.UTF_8));
        }

        conn.connect();
        InputStream is = conn.getInputStream();
        return Utils.readInput(is);
    }

    private String getJsonBody() {
            return GsonHelper.get().toJson(this.data);
    }

    private String getChecksum() {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha256.digest(getJsonBody().getBytes(StandardCharsets.UTF_8));
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("SHA-256 is not supported");
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

    private String pathWithParams() {
        return apiVersion() + path + "?" + canonicalQueryString(getSignedParams());
    }

    private static String canonicalQueryString(Map<String,Object> params) {
        Map<String, Object> paramsCopy = new HashMap<>(params);
        paramsCopy.remove(KEY_FILE);

        List<String> queryParams = Utils.mapToStringList(paramsCopy, null);

        Collections.sort(queryParams);

        StringBuilder queryString = new StringBuilder();

        final int lastQueryParamsIndex = queryParams.size()-1;
        for(String s : queryParams.subList(0, lastQueryParamsIndex)) {
            queryString.append(s).append("&");
        }
        queryString.append(queryParams.get(lastQueryParamsIndex));

        return queryString.toString();
    }

    private Map<String, Object> getSignedParams() {
        Map<String, Object> signedParams = (data != null && !json) ?
                new HashMap<>(data) : new HashMap<String, Object>();

        if(factoryId != null)
            signedParams.put("factory_id", factoryId);

        signedParams.put("access_key", credentials.getAccessKey());
        signedParams.put("timestamp", timestamp != null ? timestamp : Utils.isoTimestamp());

        if (json) {
            signedParams.put("signature_version", "2");
            signedParams.put("checksum", getChecksum());
        }

        Map<String, Object> additionalParams = new HashMap<>(signedParams);
        additionalParams.remove("file");

        String signature = generateSignature(additionalParams);
        signedParams.put("signature", signature);
        return signedParams;
    }

    private String generateSignature(Map<String, Object> params) {
        final String stringToSign = httpMethod.name() + "\n" +
                credentials.getApiHost().toLowerCase() + "\n" +
                path + "\n" + canonicalQueryString(params);

        return Utils.getHash(credentials.getSecretKey(), stringToSign);
    }

    private HttpProtocol apiProtocol() {
        return credentials.isDefaultApiPort() ? HttpProtocol.HTTPS : HttpProtocol.HTTP;
    }

    private int apiPort() {
        return credentials.getApiPort() != 80 ? credentials.getApiPort() : -1;
    }

    private String apiVersion() {
        return "/v" + credentials.getApiVersion();
    }

    public static class Builder {

        private final TelestreamCloudCredentials credentials;
        private String factoryId;
        private HttpMethod httpMethod;
        private String apiPath;
        private Map<String, Object> data;
        private String timestamp;
        private Boolean json;

        public Builder(TelestreamCloudCredentials credentials) {
            if(credentials == null) throw new IllegalArgumentException("Credentials cannot be null.");

            this.httpMethod = HttpMethod.GET;
            this.credentials = credentials;
            this.json = false;
        }

        public Builder get() {
            return method(HttpMethod.GET);
        }

        public Builder post() {
            return method(HttpMethod.POST);
        }

        public Builder put() {
            return method(HttpMethod.PUT);
        }

        public Builder delete() {
            return method(HttpMethod.DELETE);
        }

        public Builder apiPath(String apiPath) {
            this.apiPath = apiPath + ".json";
            return this;
        }

        public Builder data(Map<String, Object> data) {
            this.data = data;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder factoryId(String factoryId) {
            this.factoryId = factoryId;
            return this;
        }

        public Builder httpMethod(String httpMethod) {
            this.httpMethod = HttpMethod.valueOf(httpMethod);
            return this;
        }

        public Builder json() {
            this.json = true;
            return this;
        }

        private Builder method(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public TelestreamCloudRequest build() {
            return new TelestreamCloudRequest(this);
        }
    }
}
