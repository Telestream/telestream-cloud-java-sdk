package net.telestream.cloud.flip;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciejwitowski on 1/28/16.
 */
public class ChunkUploader {
    private HttpURLConnection httpConn;
    private String charset;
    private OutputStream outputStream;
    private PrintWriter writer;
    private final int contentLength;

    public ChunkUploader(String requestURL, int part, int contentLength)
            throws IOException{
        this.charset = "UTF-8";
        this.contentLength = contentLength;

        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestProperty("X-Part", Integer.toString(part));
        httpConn.setRequestProperty("Content-Type", "application/octet-stream");
        httpConn.setRequestProperty("Content-Length", String.valueOf(contentLength));

        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
                true);
    }

    public HttpResponse uploadChunk(byte[] chunk) throws IOException {
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
}