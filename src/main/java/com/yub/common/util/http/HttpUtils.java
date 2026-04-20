package com.yub.common.util.http;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: HTTP 工具类（基于 OkHttp）
 * @Version: 1.0.0
 */
public final class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    /** 私有构造器，禁止实例化 */
    private HttpUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * GET 请求
     *
     * @param url 请求地址
     * @return 响应字符串
     * @throws IOException IO 异常
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return execute(request);
    }

    /**
     * GET 请求（带请求头）
     *
     * @param url 请求地址
     * @param headers 请求头
     * @return 响应字符串
     * @throws IOException IO 异常
     */
    public static String get(String url, Map<String, String> headers) throws IOException {
        Request.Builder builder = new Request.Builder().url(url).get();
        if (headers != null) {
            headers.forEach(builder::addHeader);
        }
        return execute(builder.build());
    }

    /**
     * POST 请求（JSON）
     *
     * @param url 请求地址
     * @param json JSON 请求体
     * @return 响应字符串
     * @throws IOException IO 异常
     */
    public static String postJson(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return execute(request);
    }

    /**
     * POST 请求（表单）
     *
     * @param url 请求地址
     * @param formData 表单数据
     * @return 响应字符串
     * @throws IOException IO 异常
     */
    public static String postForm(String url, Map<String, String> formData) throws IOException {
        FormBody.Builder formBuilder = new FormBody.Builder();
        if (formData != null) {
            formData.forEach(formBuilder::add);
        }
        RequestBody body = formBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return execute(request);
    }

    /**
     * 执行请求
     *
     * @param request 请求
     * @return 响应字符串
     * @throws IOException IO 异常
     */
    private static String execute(Request request) throws IOException {
        try (Response response = CLIENT.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
            return null;
        }
    }
}