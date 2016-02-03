package services;

import cloud.TelestreamCloudCredentials;
import cloud.TelestreamCloudRequest;
import com.google.gson.Gson;
import utils.GsonHelper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by maciejwitowski on 1/18/16.
 */
public abstract class ApiService<T> {

    protected final TelestreamCloudCredentials credentials;

    public ApiService(TelestreamCloudCredentials credentials) {
        this.credentials = credentials;
    }

    private Gson gson = GsonHelper.get();

    public List<T> all() throws IOException {
        TelestreamCloudRequest.Builder requestBuilder = new TelestreamCloudRequest.Builder(credentials)
                .get()
                .apiPath(path());

        // Subclasses of ApiService can add additional request properties, eg. factoryId
        setAdditionalAllRequestParams(requestBuilder);
        String response = requestBuilder.build().send();

        return gson.fromJson(response, collectionType());
    }

    public T find(String id) throws IOException {
        TelestreamCloudRequest.Builder requestBuilder = new TelestreamCloudRequest.Builder(credentials)
                .get()
                .apiPath(pathWithId(id));

        // Subclasses of ApiService can add additional request properties, eg. factoryId
        setAdditionalAllRequestParams(requestBuilder);

        String response = requestBuilder.build().send();
        return gson.fromJson(response, itemType());
    }

    public T create(Map<String, Object> data) throws IOException {
        TelestreamCloudRequest.Builder requestBuilder = new TelestreamCloudRequest.Builder(credentials)
                .post()
                .apiPath(path())
                .data(data);

        setAdditionalAllRequestParams(requestBuilder);

        String response = requestBuilder.build().send();
        return gson.fromJson(response, itemType());
    }

    public String delete(String id) throws IOException {
        TelestreamCloudRequest.Builder requestBuilder = new TelestreamCloudRequest.Builder(credentials)
                .delete()
                .apiPath(pathWithId(id));

        setAdditionalAllRequestParams(requestBuilder);

        return requestBuilder.build().send();
    }

    protected String pathWithId(String id) {
        return path() + "/" + id;
    }

    abstract String path();
    abstract Type itemType();
    abstract Type collectionType();
    abstract void setAdditionalAllRequestParams(TelestreamCloudRequest.Builder builder);
}
