package com.yub.common.model;

import com.yub.common.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 统一响应模型
 * @Version: 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private int code;

    /** 状态信息 */
    private String message;

    /** 响应数据 */
    private T data;

    /** 时间戳 */
    private long timestamp;

    /**
     * 创建成功响应
     *
     * @param <T> 数据类型
     * @return 成功响应
     */
    public static <T> Response<T> success() {
        return success(null);
    }

    /**
     * 创建成功响应
     *
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 成功响应
     */
    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMessage())
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 创建失败响应
     *
     * @param responseCode 响应码
     * @param <T> 数据类型
     * @return 失败响应
     */
    public static <T> Response<T> error(ResponseCode responseCode) {
        return Response.<T>builder()
                .code(responseCode.getCode())
                .message(responseCode.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 创建失败响应
     *
     * @param code 错误码
     * @param message 错误信息
     * @param <T> 数据类型
     * @return 失败响应
     */
    public static <T> Response<T> error(int code, String message) {
        return Response.<T>builder()
                .code(code)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 创建业务异常响应
     *
     * @param responseCode 响应码
     * @param message 自定义消息
     * @param <T> 数据类型
     * @return 业务异常响应
     */
    public static <T> Response<T> error(ResponseCode responseCode, String message) {
        return Response.<T>builder()
                .code(responseCode.getCode())
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
