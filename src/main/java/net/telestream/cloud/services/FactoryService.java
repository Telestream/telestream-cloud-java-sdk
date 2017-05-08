package net.telestream.cloud.services;

import net.telestream.cloud.TelestreamCloudCredentials;
import net.telestream.cloud.TelestreamCloudRequest;
import net.telestream.cloud.UploadSession;
import com.google.gson.reflect.TypeToken;
import net.telestream.cloud.objects.Factory;
import net.telestream.cloud.objects.Notifications;
import net.telestream.cloud.utils.GsonHelper;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/18/16.
 */
public class FactoryService extends ApiService<Factory> {

    private static final String PATH = "/factories";

    public static final Type TYPE_FACTORIES_LIST = new TypeToken<List<Factory>>(){}.getType();
    public static final Type TYPE_FACTORY = new TypeToken<Factory>(){}.getType();

    public FactoryService(TelestreamCloudCredentials credentials) {
        super(credentials);
    }

    @Override
    String path() {
        return PATH;
    }

    @Override
    Type itemType() {
        return TYPE_FACTORY;
    }

    @Override
    Type collectionType() {
        return TYPE_FACTORIES_LIST;
    }

    @Override
    void setAdditionalAllRequestParams(TelestreamCloudRequest.Builder builder) {
        // Nothing
    }

    public VideoService videoService(String factoryId) {
        return VideoService.forFactory(credentials, factoryId);
    }

    public EncodingService encodingService(String factoryId) {
        return EncodingService.forFactory(credentials, factoryId);
    }

    public ProfileService profileService(String factoryId) {
        return ProfileService.forFactory(credentials, factoryId);
    }

    public Notifications getNotifications(String factoryId) {
        return NotificationsService
                .forFactory(credentials, factoryId)
                .get();
    }

    public Notifications updateNotifications(String factoryId, Notifications notifications) {
        return NotificationsService
                .forFactory(credentials, factoryId)
                .save(notifications);
    }

    public Factory save(Factory factory) {
        TelestreamCloudRequest request = new TelestreamCloudRequest.Builder(credentials)
                .put()
                .apiPath(pathWithId(factory.getId()))
                .data(factory.getAttributesMap())
                .build();

        return GsonHelper.get().fromJson(request.send(), TYPE_FACTORY);
    }

    @Override
    public String delete(String id) {
        throw new IllegalStateException("Factory cannot be deleted.");
    }

    public UploadSession initUploadSession(String factoryId, File file, Map<String, Object> params) {
        return UploadSession.init(credentials, factoryId, file, params);
    }
}
