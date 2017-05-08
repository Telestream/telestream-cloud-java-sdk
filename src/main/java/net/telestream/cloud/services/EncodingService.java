package net.telestream.cloud.services;

import net.telestream.cloud.TelestreamCloudCredentials;
import net.telestream.cloud.TelestreamCloudRequest;
import com.google.gson.reflect.TypeToken;
import net.telestream.cloud.objects.Encoding;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class EncodingService extends ApiService<Encoding> {
    public static final Type TYPE_ENCODINGS_LIST = new TypeToken<List<Encoding>>(){}.getType();
    public static final Type TYPE_ENCODING = new TypeToken<Encoding>(){}.getType();

    public static final String PATH = "/encodings";

    private String factoryId;
    private String videoId;

    public EncodingService(TelestreamCloudCredentials credentials) {
        super(credentials);
    }

    public static EncodingService forFactory(TelestreamCloudCredentials credentials, String factoryId) {
        EncodingService encodingService = new EncodingService(credentials);
        encodingService.factoryId = factoryId;
        return encodingService;
    }

    public static EncodingService forFactoryVideo(TelestreamCloudCredentials credentials, String factoryId, String videoId) {
        EncodingService encodingService = forFactory(credentials, factoryId);
        encodingService.videoId = videoId;
        return encodingService;
    }

    @Override
    String path() {
        return (videoId != null) ? videoEncodingPath() : PATH;
    }

    @Override
    Type itemType() {
        return TYPE_ENCODING;
    }

    @Override
    Type collectionType() {
        return TYPE_ENCODINGS_LIST;
    }

    private String videoEncodingPath() {
        return VideoService.PATH + "/" + videoId + PATH;
    }

    @Override
    void setAdditionalAllRequestParams(TelestreamCloudRequest.Builder builder) {
        if(factoryId != null) {
            builder.factoryId(factoryId);
        }
    }

    public String retry(String encodingId) {
        if(factoryId == null || encodingId == null)
            throw new IllegalStateException("Factory Id or Encoding Id are null.");

        TelestreamCloudRequest.Builder builder = new TelestreamCloudRequest.Builder(credentials)
                .post()
                .apiPath(pathWithId(encodingId) + "/retry")
                .factoryId(factoryId);

        return builder.build().send();
    }

    public String cancel(String encodingId) {
        if(factoryId == null || encodingId == null)
            throw new IllegalStateException("Factory Id or Encoding Id are null.");

        TelestreamCloudRequest.Builder builder = new TelestreamCloudRequest.Builder(credentials)
                .post()
                .apiPath(pathWithId(encodingId) + "/cancel")
                .factoryId(factoryId);

        return builder.build().send();
    }
}
