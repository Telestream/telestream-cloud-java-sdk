package net.telestream.cloud.objects;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class Encoding {
    private final String id;
    private final Status status;
    private final List<String> files;
    private final String profileId;
    private final String profileName;
    private final Date createdAt;
    private final Date updatedAt;
    private final String audioCodec;
    private final Long fileSize;
    private final Integer duration;
    private final Integer encodingTime;
    private final Integer encodingProgress;
    private final String fps;
    private final String mimeType;
    private final Integer audioChannels;
    private final String logfileUrl;
    private final Integer audioBitrate;
    private final String path;
    private final Integer audioSampleRate;
    private final Date startedEncodingAt;
    private final String videoId;
    private final String extname;
    private final Integer videoBitrate;
    private final String videoCodec;

    public Encoding(String id, Status status, List<String> files, String profileId, String profileName, Date createdAt, Date updatedAt, String audioCodec, Long fileSize, Integer duration, Integer encodingTime, Integer encodingProgress, String fps, String mimeType, Integer audioChannels, String logfileUrl, Integer audioBitrate, String path, Integer audioSampleRate, Date startedEncodingAt, String videoId, String extname, Integer videoBitrate, String videoCodec) {
        this.id = id;
        this.status = status;
        this.files = files;
        this.profileId = profileId;
        this.profileName = profileName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.audioCodec = audioCodec;
        this.fileSize = fileSize;
        this.duration = duration;
        this.encodingTime = encodingTime;
        this.encodingProgress = encodingProgress;
        this.fps = fps;
        this.mimeType = mimeType;
        this.audioChannels = audioChannels;
        this.logfileUrl = logfileUrl;
        this.audioBitrate = audioBitrate;
        this.path = path;
        this.audioSampleRate = audioSampleRate;
        this.startedEncodingAt = startedEncodingAt;
        this.videoId = videoId;
        this.extname = extname;
        this.videoBitrate = videoBitrate;
        this.videoCodec = videoCodec;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getEncodingTime() {
        return encodingTime;
    }

    public Integer getEncodingProgress() {
        return encodingProgress;
    }

    public String getFps() {
        return fps;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getAudioChannels() {
        return audioChannels;
    }

    public String getLogfileUrl() {
        return logfileUrl;
    }

    public Integer getAudioBitrate() {
        return audioBitrate;
    }

    public String getPath() {
        return path;
    }

    public Integer getAudioSampleRate() {
        return audioSampleRate;
    }

    public Date getStartedEncodingAt() {
        return startedEncodingAt;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getExtname() {
        return extname;
    }

    public Integer getVideoBitrate() {
        return videoBitrate;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public Map<String, Object> getAttributesMap() {
        return null;
    }
}
