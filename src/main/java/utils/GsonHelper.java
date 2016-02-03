package utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by maciejwitowski on 1/28/16.
 */
public class GsonHelper {

    static final Gson GSON = new GsonBuilder().serializeNulls()
            .setDateFormat("yyyy/MM/dd HH:mm:ss Z")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static Gson get() {
        return GSON;
    }
}
