package cloud;

import utils.MultipartUploader;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public TelestreamCloudRequest(Builder builder) {
        this.httpMethod = builder.httpMethod;
        this.path = builder.apiPath;
        this.credentials = builder.credentials;
        this.factoryId = builder.factoryId;
        this.data = builder.data;
        this.timestamp = builder.timestamp;
    }

    public String send() throws IOException {
        String result;
        String pathWithParams = apiVersion() + path + "?" + canonicalQueryString(getSignedParams());

        URL url = new URL(apiProtocol().name(), credentials.getApiHost(), apiPort(), pathWithParams);

        boolean isUploadingFile = httpMethod.equals(HttpMethod.POST) && data.containsKey(KEY_FILE);

        if(isUploadingFile) {
            MultipartUploader multipart = new MultipartUploader(url.toString(), Utils.UTF_8);
            multipart.addFilePart(KEY_FILE, (File) data.get(KEY_FILE));
            result = multipart.finish().get(0);
        } else {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(httpMethod.name());
            conn.connect();
            InputStream is = conn.getInputStream();
            result = Utils.readInput(is);
        }

        return result;
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

        return queryString.toString()
                .replace("%7E", "~")
                .replace(":", "%3A").replace("+", "%2B")
                .replace(" ", "%20").replace("/", "%2F");
    }

    private Map<String, Object> getSignedParams() {
        Map<String, Object> signedParams = (data != null) ?
                new HashMap<>(data) : new HashMap<String, Object>();

        if(factoryId != null)
            signedParams.put("factory_id", factoryId);

        signedParams.put("access_key", credentials.getAccessKey());
        signedParams.put("timestamp", timestamp != null ? timestamp : Utils.isoTimestamp());

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

        public Builder(TelestreamCloudCredentials credentials) {
            if(credentials == null) throw new IllegalArgumentException("Credentials cannot be null.");

            this.httpMethod = HttpMethod.GET;
            this.credentials = credentials;
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

        private Builder method(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public TelestreamCloudRequest build() {
            return new TelestreamCloudRequest(this);
        }
    }
}
