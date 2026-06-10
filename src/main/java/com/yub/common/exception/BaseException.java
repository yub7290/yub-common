package com.yub.common.exception;

import lombok.Getter;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 基础业务异常
 * @Version: 1.0.0
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String message;

    /**
     * 构造器（使用 ResponseCode 枚举）
     *
     * @param errorCode 响应码枚举
     */
    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 构造器（使用 ResponseCode 枚举 + cause）
     *
     * @param errorCode 响应码枚举
     * @param cause     异常原因
     */
    public BaseException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}