package cloud;

import utils.MultipartUploader;
import utils.Utils;
import utils.GsonHelper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

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
    final Map<String, Object> data_body;
    private String json_body; // JSON-encoded parameters contained in data_body above
    final String timestamp;
    final boolean useSignatureVer2;

    public TelestreamCloudRequest(Builder builder) {
        this.httpMethod = builder.httpMethod;
        this.path = builder.apiPath;
        this.credentials = builder.credentials;
        this.factoryId = builder.factoryId;
        this.data = builder.data;
        this.data_body = builder.data_body;
        this.timestamp = builder.timestamp;
        this.useSignatureVer2 = builder.useSignatureVer2;
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
        return isUploadingFile() ? getMultipartResponse(url) : getResponse(url);
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
        if(useSignatureVer2) {
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-length", String.valueOf(json_body.length()));

            //send the json as body of the request
            conn.setDoOutput(true);
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(json_body.getBytes());
            outputStream.close();
        }
        conn.connect();
        InputStream is = conn.getInputStream();
        return Utils.readInput(is);
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

        return queryString.toString()
                .replace("%7E", "~")
                .replace(":", "%3A").replace("+", "%2B")
                .replace(" ", "%20").replace("/", "%2F");
    }

    private Map<String, Object> getSignedParams() {
        Map<String, Object> signedParams = new HashMap<>();

        if(useSignatureVer2) {
            signedParams.put("signature_version", 2);
            json_body = GsonHelper.get().toJson(data_body);
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String checksum = DatatypeConverter.printHexBinary(md.digest(json_body.getBytes()));
                signedParams.put("checksum", checksum.toLowerCase());
            }
            catch (Exception e) {
                System.out.println("Error generating SHA-256 checksum");
            }
            signedParams.putAll(data);
        } else if(data != null) {
            signedParams.putAll(data);
        }

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
        private Map<String, Object> data_body;
        private String timestamp;
        private boolean useSignatureVer2;

        public Builder(TelestreamCloudCredentials credentials) {
            if(credentials == null) throw new IllegalArgumentException("Credentials cannot be null.");

            this.httpMethod = HttpMethod.GET;
            this.credentials = credentials;
            this.useSignatureVer2 = false;
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

        public Builder body(Map<String, Object> body) {
            this.data_body = body;
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

        public Builder signatureVer2(boolean signVer2Flag) {
            this.useSignatureVer2 = signVer2Flag;
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
