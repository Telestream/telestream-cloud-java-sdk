package net.telestream;

import net.telestream.cloud.Flip;
import net.telestream.cloud.Resource;
import net.telestream.cloud.TelestreamCloudCredentials;
import net.telestream.cloud.TelestreamCloudRequest;
import net.telestream.cloud.objects.Encoding;
import net.telestream.cloud.objects.Profile;
import net.telestream.cloud.objects.Video;
import net.telestream.cloud.services.EncodingService;
import net.telestream.cloud.services.ProfileService;
import net.telestream.cloud.services.VideoService;

import java.util.List;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/16/16.
 */
public class TelestreamCloud {

    private final TelestreamCloudCredentials credentials;

    public TelestreamCloud(String access_key, String access_secret) {
        this.credentials = new TelestreamCloudCredentials(access_key, access_secret);
    }

    public void setApiHost(String apiHost) {
        this.credentials.setApiHost(apiHost);
    }

    public void setApiPort(int apiPort) {
        this.credentials.setApiPort(apiPort);
    }

    public void setApiVersion(String apiVersion) {
        this.credentials.setApiVersion(apiVersion);
    }

    public String signedParams(String httpMethod, String path) {
        return signedParams(httpMethod, path, null);
    }

    public String signedParams(String httpMethod, String path, Map<String, Object> params) {
        return new TelestreamCloudRequest.Builder(credentials)
                .httpMethod(httpMethod)
                .apiPath(path)
                .data(params)
                .build()
                .send();
    }

    public enum ResourceType {
        FLIP
    }

    public Resource getResource(ResourceType resourceType) {
        switch (resourceType) {
            case FLIP:
                return new Flip(credentials);
        }

        return null;
    }

    public List<Video> getVideos(String factoryId) {
        return VideoService.forFactory(credentials, factoryId).all();
    }

    public Video getVideo(String factoryId, String videoId) {
        return VideoService.forFactory(credentials, factoryId).find(videoId);
    }

    public List<Profile> getProfiles(String factoryId) {
        return ProfileService.forFactory(credentials, factoryId).all();
    }

    public Profile getProfile(String factoryId, String profileId) {
        return ProfileService.forFactory(credentials, factoryId).find(profileId);
    }

    public List<Encoding> getEncodings(String factoryId) {
        return EncodingService.forFactory(credentials, factoryId).all();
    }

    public Encoding getEncoding(String factoryId, String encodingId) {
        return EncodingService.forFactory(credentials, factoryId).find(encodingId);
    }

    public Encoding createEncoding(String factoryId, Map<String, Object> params) {
        return EncodingService.forFactory(credentials, factoryId).create(params);
    }

    public Profile createProfile(String factoryId, Map<String, Object> params) {
        return ProfileService.forFactory(credentials, factoryId).create(params);
    }

    public Video createVideo(String factoryId, Map<String, Object> params) {
        return VideoService.forFactory(credentials, factoryId).create(params);
    }

    public String deleteProfile(String factoryId, String profileId) {
        return ProfileService.forFactory(credentials, factoryId).delete(profileId);
    }

    public String deleteVideo(String factoryId, String videoId) {
        return VideoService.forFactory(credentials, factoryId).delete(videoId);
    }

    public String deleteEncoding(String factoryId, String encodingId) {
        return EncodingService.forFactory(credentials, factoryId).delete(encodingId);
    }
}
