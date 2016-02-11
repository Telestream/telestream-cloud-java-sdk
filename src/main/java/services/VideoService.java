package services;

import cloud.TelestreamCloudCredentials;
import cloud.TelestreamCloudRequest;
import com.google.gson.reflect.TypeToken;
import objects.Video;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by maciejwitowski on 1/18/16.
 */
public class VideoService extends ApiService<Video> {

    public static final Type TYPE_VIDEOS_LIST = new TypeToken<List<Video>>(){}.getType();
    public static final Type TYPE_VIDEO = new TypeToken<Video>(){}.getType();

    public static final String PATH = "/videos";

    private String factoryId;

    public VideoService(TelestreamCloudCredentials credentials) {
        super(credentials);
    }

    public static VideoService forFactory(TelestreamCloudCredentials credentials, String factoryId) {
        VideoService videoService = new VideoService(credentials);
        videoService.factoryId = factoryId;
        return videoService;
    }

    public EncodingService encodingService(String videoId) {
        if(factoryId == null || videoId == null)
            throw new IllegalArgumentException("Factory Id and Video Id are needed.");

        return EncodingService.forFactoryVideo(credentials, factoryId, videoId);
    }

    @Override
    String path() {
        return PATH;
    }

    @Override
    Type itemType() {
        return TYPE_VIDEO;
    }

    @Override
    Type collectionType() {
        return TYPE_VIDEOS_LIST;
    }

    @Override
    void setAdditionalAllRequestParams(TelestreamCloudRequest.Builder builder) {
        if(factoryId != null) {
            builder.factoryId(factoryId);
        }
    }

    public String metadata(String videoId) {
        if(factoryId == null || videoId == null)
            throw new IllegalStateException("Factory Id or Video Id are null.");

        TelestreamCloudRequest.Builder builder = new TelestreamCloudRequest.Builder(credentials)
                .get()
                .apiPath(pathWithId(videoId) + "/metadata")
                .factoryId(factoryId);

        return builder.build().send();
    }

    public String deleteSourceFile(String videoId) {
        if(factoryId == null || videoId == null)
            throw new IllegalStateException("Factory Id or Video Id are null.");

        TelestreamCloudRequest.Builder builder = new TelestreamCloudRequest.Builder(credentials)
                .delete()
                .apiPath(pathWithId(videoId) + "/source")
                .factoryId(factoryId);

        return builder.build().send();
    }
}
