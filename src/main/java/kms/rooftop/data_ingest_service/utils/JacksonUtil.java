package kms.rooftop.data_ingest_service.utils;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public final class JacksonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private JacksonUtil(){}

    public static JsonNode toJsonNode(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readTree(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse json payload", e);
        }
    }

    public static String toString(JsonNode node) {
        if (node == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(node);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize json payload", e);
        }
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize payload to JSON string", e);
        }
    }

    public static <T> T toObject(String content, Class<T> valueType) {
        if (content == null || content.isBlank()) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to deserialize JSON string to Object", e);
        }
    }
}
