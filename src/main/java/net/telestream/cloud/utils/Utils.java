package net.telestream.cloud.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by maciejwitowski on 1/21/16.
 */
public class Utils {
    private static final String HASH_ALGORITHM = "HmacSHA256";
    public static final String UTF_8 = "UTF-8";

    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
    private static final DateFormat UTC_IN_ISO_FORMAT;

    static {
        UTC_IN_ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        UTC_IN_ISO_FORMAT.setTimeZone(UTC_TIME_ZONE);
    }
    public static String isoTimestamp() {
        return UTC_IN_ISO_FORMAT.format(new Date());
    }

    public static String getHash(String key, String data) {
        String hash = null;
        try {
            Mac sha256HMAC = Mac.getInstance(HASH_ALGORITHM);
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), HASH_ALGORITHM);
            sha256HMAC.init(secret_key);

            hash = Base64.encode(sha256HMAC.doFinal(data.getBytes()));
        }
        catch (Exception e){
            System.out.println("Error");
        }

        return hash;
    }

    public static String readInput(InputStream stream) throws IOException {
        int ch;
        StringBuilder sb = new StringBuilder();
        while((ch = stream.read())!= -1)
            sb.append((char)ch);
        return sb.toString();
    }

    public static List<String> mapToStringList(Map<String, Object> params, String base) {
        List<String> flat = new ArrayList<>();

        for(Map.Entry<String, Object> param : params.entrySet()) {
            final String key = param.getKey();
            final Object value = param.getValue();

            if(value instanceof Map) {
                flat.addAll(mapToStringList((Map<String, Object>) value, key));
            } else {
                String basedKey = (base!=null) ? base + "[" + key + "]" : key;
                flat.add(basedKey + "=" + String.valueOf(value));
            }
        }

        return flat;
    }
}
