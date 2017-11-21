package net.telestream.cloud.flip;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciejwitowski on 1/28/16.
 */
public class CouchClient {
    private HttpURLConnection httpConn;
    private String charset;
    private OutputStream outputStream;
    private PrintWriter writer;

    public CouchClient(String requestURL) throws IOException {
        this.charset = "UTF-8";
        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoInput(true);

    }

    public HttpResponse uploadChunk(int part, int contentLength, byte[] chunk, String tag) throws IOException {
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setRequestProperty("X-Part", Integer.toString(part));
        httpConn.setRequestProperty("Content-Type", "application/octet-stream");
        httpConn.setRequestProperty("Content-Length", String.valueOf(contentLength));
        if (tag != null) httpConn.setRequestProperty("X-Extra-File-Tag", tag);
        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(chunk));

        byte[] buffer = new byte[contentLength];
        int bytesRead = inputStream.read(buffer);

        if(bytesRead != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.flush();
        inputStream.close();
        writer.flush();
        writer.close();

        return getResponse();
    }

    public HttpResponse getMissingParts(String tag) throws IOException {
        httpConn.setRequestProperty("Content-Type", "application/json");
        if (tag != null) httpConn.setRequestProperty("X-Extra-File-Tag", tag);
        return getResponse();
    }

    private HttpResponse getResponse() throws IOException {
        List<String> response = new ArrayList<String>();

        // checks server's status code first
        int status = httpConn.getResponseCode();

        HttpResponse httpResponse = new HttpResponse(status);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpConn.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            response.add(line);
        }

        if(response.size() > 0) {
            httpResponse.setBody(response.get(0));
        }
        reader.close();
        httpConn.disconnect();
        return httpResponse;
    }

    public static class HttpResponse {
        private final int status;
        private String body;

        public HttpResponse(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    public static class MissingPartsResponse {
        public ArrayList<Integer> missingParts;

        public ArrayList<Integer> getMissingParts() {
            return missingParts;
        }
    }
}