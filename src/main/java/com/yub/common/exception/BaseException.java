package com.yub.common.exception;

import lombok.Getter;

import java.util.IllegalFormatException;

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

    /**
     * 支持参数化消息的异常构造器
     *
     * @param errorCode 错误码枚举
     * @param args      消息模板中的参数（按顺序替换 %s、%d 等）
     */
    public BaseException(ErrorCode errorCode, Object... args) {
        this(null, errorCode, args);
    }

    /**
     * 支持参数化消息 + 根因的异常构造器
     *
     * @param errorCode 错误码枚举
     * @param cause     原始异常
     * @param args      消息模板中的参数
     */
    public BaseException(Throwable cause, ErrorCode errorCode, Object... args) {
        super(formatMessage(errorCode, args), cause);
        this.code = errorCode.getCode();
        this.message = super.getMessage();  // 使用父类已格式化的消息
    }

    /**
     * 格式化消息：若模板和参数匹配则返回格式化字符串，否则返回原始模板（并记录日志）
     */
    private static String formatMessage(ErrorCode errorCode, Object... args) {
        String template = errorCode.getMessage();
        if (args == null || args.length == 0) {
            return template;   // 无参数时直接返回模板
        }
        try {
            return String.format(template, args);
        } catch (IllegalFormatException e) {
            // 格式不匹配时降级返回原始模板（避免异常掩盖业务异常）
            return template;
        }
    }
}