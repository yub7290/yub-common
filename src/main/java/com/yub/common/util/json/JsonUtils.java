package com.yub.common.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: JSON 工具类（基于 Jackson）
 * @Version: 1.0.0
 */
public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 注册 Java 8 时间模块
        MAPPER.registerModule(new JavaTimeModule());
        // 禁用写入日期作为时间戳
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /** 私有构造器，禁止实例化 */
    private JsonUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 对象转 JSON 字符串
     *
     * @param obj 对象
     * @return JSON 字符串
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to JSON", e);
        }
    }

    /**
     * 对象转格式化 JSON 字符串
     *
     * @param obj 对象
     * @return 格式化后的 JSON 字符串
     */
    public static String toPrettyJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to JSON", e);
        }
    }

    /**
     * JSON 字符串转对象
     *
     * @param json JSON 字符串
     * @param clazz 对象类型
     * @param <T> 对象类型
     * @return 对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json == null || clazz == null) {
            return null;
        }
        try {
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize JSON to object", e);
        }
    }

    /**
     * 深拷贝对象（通过 JSON 序列化/反序列化实现）
     *
     * @param obj 对象
     * @param clazz 对象类型
     * @param <T> 对象类型
     * @return 深拷贝后的对象
     */
    public static <T> T deepCopy(Object obj, Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        String json = toJson(obj);
        return fromJson(json, clazz);
    }

    /**
     * 判断是否为有效的 JSON 字符串
     *
     * @param json JSON 字符串
     * @return 是否有效
     */
    public static boolean isValid(String json) {
        if (json == null) {
            return false;
        }
        try {
            MAPPER.readTree(json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}