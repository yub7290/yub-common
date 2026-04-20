package com.yub.common.exception;

import com.yub.common.enums.ResponseCode;
import lombok.Getter;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 基础业务异常
 * @Version: 1.0.0
 */
@Getter
public class BaseException extends RuntimeException {

    /** 错误码 */
    private final int code;

    /** 错误信息 */
    private final String message;

    /**
     * 构造器
     *
     * @param code 错误码
     * @param message 错误信息
     */
    public BaseException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 构造器（使用 ResponseCode 枚举）
     *
     * @param responseCode 响应码枚举
     */
    public BaseException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    /**
     * 构造器（使用 ResponseCode 枚举 + 自定义消息）
     *
     * @param responseCode 响应码枚举
     * @param message 自定义消息
     */
    public BaseException(ResponseCode responseCode, String message) {
        super(message);
        this.code = responseCode.getCode();
        this.message = message;
    }

    /**
     * 构造器（使用 ResponseCode 枚举 + cause）
     *
     * @param responseCode 响应码枚举
     * @param cause 异常原因
     */
    public BaseException(ResponseCode responseCode, Throwable cause) {
        super(responseCode.getMessage(), cause);
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}