package net.telestream.cloud.objects;

import java.util.Date;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class Profile extends Model {
    private String id;
    private Float fps;
    private String name;
    private String presetName;
    private String x264Options;
    private Integer videoBitrate;
    private String title;
    private Date createdAt;
    private Date updatedAt;
    private String extname;
    private Integer priority;
    private Boolean upscale;
    private Integer width;
    private Integer height;
    private String aspectMode;
    private Integer audioSampleRate;
    private Integer audioBitrate;
    private Boolean timeCode;
    private Integer keyframeInterval;
    private String stack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public String getX264Options() {
        return x264Options;
    }

    public void setX264Options(String x264Options) {
        this.x264Options = x264Options;
    }

    public Integer getVideoBitrate() {
        return videoBitrate;
    }

    public void setVideoBitrate(Integer videoBitrate) {
        this.videoBitrate = videoBitrate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getUpscale() {
        return upscale;
    }

    public void setUpscale(Boolean upscale) {
        this.upscale = upscale;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAspectMode() {
        return aspectMode;
    }

    public void setAspectMode(String aspectMode) {
        this.aspectMode = aspectMode;
    }

    public Integer getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(Integer audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public Integer getAudioBitrate() {
        return audioBitrate;
    }

    public void setAudioBitrate(Integer audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    public Boolean getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(Boolean timeCode) {
        this.timeCode = timeCode;
    }

    public Integer getKeyframeInterval() {
        return keyframeInterval;
    }

    public void setKeyframeInterval(Integer keyframeInterval) {
        this.keyframeInterval = keyframeInterval;
    }

    public Float getFps() {
        return fps;
    }

    public void setFps(Float fps) {
        this.fps = fps;
    }
}
