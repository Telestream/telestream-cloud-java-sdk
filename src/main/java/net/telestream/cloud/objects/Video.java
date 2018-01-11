package net.telestream.cloud.objects;

import java.util.Date;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/18/16.
 */
public class Video extends Model {
    private final String id;
    private final Status status;
    private final String extname;
    private final Integer audioSampleRate;
    private final String audioCodec;
    private final Float fps;
    private final Date createdAt;
    private final Date updatedAt;
    private final String sourceUrl;
    private final Integer width;
    private final Integer height;
    private final Integer audioChannels;
    private final Integer videoBitrate;
    private final String originalFilename;
    private final Long fileSize;
    private final Integer duration;
    private final String videoCodec;
    private final String path;
    private final String mimeType;
    private final Integer audioBitrate;

    public Video(String id, Status status, String extname, Integer audioSampleRate, String audioCodec, Float fps, Date createdAt, Date updatedAt, String sourceUrl, Integer width, Integer height, Integer audioChannels, Integer videoBitrate, String originalFilename, Long fileSize, Integer duration, String videoCodec, String path, String mimeType, Integer audioBitrate) {
        this.id = id;
        this.status = status;
        this.extname = extname;
        this.audioSampleRate = audioSampleRate;
        this.audioCodec = audioCodec;
        this.fps = fps;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sourceUrl = sourceUrl;
        this.width = width;
        this.height = height;
        this.audioChannels = audioChannels;
        this.videoBitrate = videoBitrate;
        this.originalFilename = originalFilename;
        this.fileSize = fileSize;
        this.duration = duration;
        this.videoCodec = videoCodec;
        this.path = path;
        this.mimeType = mimeType;
        this.audioBitrate = audioBitrate;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getExtname() {
        return extname;
    }

    public Integer getAudioSampleRate() {
        return audioSampleRate;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public Float getFps() {
        return fps;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getAudioChannels() {
        return audioChannels;
    }

    public Integer getVideoBitrate() {
        return videoBitrate;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public String getPath() {
        return path;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getAudioBitrate() {
        return audioBitrate;
    }
}
