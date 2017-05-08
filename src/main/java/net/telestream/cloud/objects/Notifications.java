package net.telestream.cloud.objects;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class Notifications {

    private static final String KEY_URL = "url";
    private static final String KEY_DELAY = "delay";
    private static final String KEY_EVENTS = "events";

    private String url;
    private Integer delay;
    private Events events;

    public String getUrl() {
        return url;
    }

    public Integer getDelay() {
        return delay;
    }

    public boolean isEnabledForEncodingCompleted() {
        return events.encodingCompleted;
    }

    public boolean isEnabledForEncodingProgress() {
        return events.encodingProgress;
    }

    public boolean isEnabledForVideoCreated() {
        return events.videoCreated;
    }

    public boolean isEnabledForVideoEncoded() {
        return events.videoEncoded;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void enableForVideoCreated(Boolean enabled) {
        events.videoCreated = enabled;
    }

    public void enableForVideoEncoded(Boolean enabled) {
        events.videoEncoded = enabled;
    }

    public void enableForEncodingProgress(Boolean enabled) {
        events.encodingProgress = enabled;
    }

    public void enableForEncodingCompleted(Boolean enabled) {
        events.encodingCompleted = enabled;
    }

    public Map<String, Object> getAttributesMap() {
        Map<String, Object> attributesMap = new HashMap<>();
        attributesMap.put(KEY_DELAY, delay);
        attributesMap.put(KEY_URL, url);
        attributesMap.put(KEY_EVENTS, events.getAttributesMap());
        return attributesMap;
    }

    static class Events {
        private static final String KEY_VIDEO_CREATED = "video_created";
        private static final String KEY_VIDEO_ENCODED = "video_encoded";
        private static final String KEY_ENCODING_PROGRESS = "encoding_progress";
        private static final String KEY_ENCODING_COMPLETED = "encoding_completed";

        private boolean encodingCompleted;
        private boolean encodingProgress;
        private boolean videoCreated;
        private boolean videoEncoded;

        public Events(boolean encodingCompleted, boolean encodingProgress, boolean videoCreated, boolean videoEncoded) {
            this.encodingCompleted = encodingCompleted;
            this.encodingProgress = encodingProgress;
            this.videoCreated = videoCreated;
            this.videoEncoded = videoEncoded;
        }

        public Map<String, Object> getAttributesMap() {
            Map<String, Object> attributesMap = new HashMap<>();
            attributesMap.put(KEY_VIDEO_CREATED, videoCreated);
            attributesMap.put(KEY_VIDEO_ENCODED, videoEncoded);
            attributesMap.put(KEY_ENCODING_PROGRESS, encodingProgress);
            attributesMap.put(KEY_ENCODING_COMPLETED, encodingCompleted);
            return attributesMap;
        }
    }
}
