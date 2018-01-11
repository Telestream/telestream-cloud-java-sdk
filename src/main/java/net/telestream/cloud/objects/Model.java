package net.telestream.cloud.objects;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<String, Object> attributesMap = new HashMap<>();

    public Map<String, Object> getAttributesMap() {
        return attributesMap;
    }

    public void setAttributesMap(Map<String, Object> attributes) {
        this.attributesMap = attributes;
    }
}
