package services;

import cloud.TelestreamCloudCredentials;
import cloud.TelestreamCloudRequest;
import com.google.gson.reflect.TypeToken;
import objects.Profile;
import utils.GsonHelper;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class ProfileService extends ApiService<Profile> {

    public static final Type TYPE_PROFILES_LIST = new TypeToken<List<Profile>>(){}.getType();
    public static final Type TYPE_PROFILE = new TypeToken<Profile>(){}.getType();

    public static final String PATH = "/profiles";

    private String factoryId;

    public ProfileService(TelestreamCloudCredentials credentials) {
        super(credentials);
    }

    public static ProfileService forFactory(TelestreamCloudCredentials credentials, String factoryId) {
        ProfileService profileService = new ProfileService(credentials);
        profileService.factoryId = factoryId;
        return profileService;
    }

    @Override
    String path() {
        return PATH;
    }

    @Override
    Type itemType() {
        return TYPE_PROFILE;
    }

    @Override
    Type collectionType() {
        return TYPE_PROFILES_LIST;
    }

    @Override
    void setAdditionalAllRequestParams(TelestreamCloudRequest.Builder builder) {
        if(factoryId != null) {
            builder.factoryId(factoryId);
        }
    }

    public Profile save(Profile profile) {
        TelestreamCloudRequest request = new TelestreamCloudRequest.Builder(credentials)
                .put()
                .apiPath(pathWithId(profile.getId()))
                .data(profile.getAttributesMap())
                .build();

        return GsonHelper.get().fromJson(request.send(), TYPE_PROFILE);
    }
}
