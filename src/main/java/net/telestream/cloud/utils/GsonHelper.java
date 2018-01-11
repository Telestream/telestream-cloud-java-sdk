package net.telestream.cloud.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.telestream.cloud.objects.Model;

import java.lang.reflect.Type;
import java.util.Map;

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

    static final Gson RawGSON = new GsonBuilder().serializeNulls()
            .setDateFormat("yyyy/MM/dd HH:mm:ss Z")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Float.class, new FloatDeserializer())
            .create();


    static class ModelDeserializer implements JsonDeserializer<Model>
    {
        @Override
        public Model deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException
        {
            Model model = RawGSON.fromJson(json, typeOfT);

            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> attributesMap = RawGSON.fromJson(json, type);
            attributesMap.remove("id");
            model.setAttributesMap(attributesMap);

            return model;
        }
    }

    static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy/MM/dd HH:mm:ss Z")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeHierarchyAdapter(Model.class, new ModelDeserializer())
            .create();


    public static Gson get() {
        return GSON;
    }
}
