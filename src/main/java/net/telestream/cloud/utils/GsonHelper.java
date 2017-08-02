package net.telestream.cloud.utils;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by maciejwitowski on 1/28/16.
 */
public class GsonHelper {
    static class FloatDeserializer implements JsonDeserializer<Float>
    {
        @Override
        public Float deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException
        {
            String value = json.getAsString();

            if (value.equals("same_as_source")) {
                return new Float(-1.0);
            }
            return Float.parseFloat(value);
        }
    }

    static final Gson GSON = new GsonBuilder().serializeNulls()
            .setDateFormat("yyyy/MM/dd HH:mm:ss Z")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Float.class, new FloatDeserializer())
            .create();

    public static Gson get() {
        return GSON;
    }
}
