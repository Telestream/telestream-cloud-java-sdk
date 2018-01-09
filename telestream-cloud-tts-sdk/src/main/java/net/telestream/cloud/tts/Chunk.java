package net.telestream.cloud.tts;

public class Chunk {
    private int id;
    private int contentLength;
    private byte[] content;

    public Chunk(int id, int contentLength, byte[] content) {
        this.id = id;
        this.contentLength = contentLength;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getContentLength() {
        return contentLength;
    }

    public byte[] getContent() {
        return content;
    }
}
