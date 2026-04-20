package com.yub.common.exception;

import com.yub.common.enums.ResponseCode;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 数据校验异常
 * @Version: 1.0.0
 */
public class ValidationException extends BaseException {

    /**
     * 构造器
     *
     * @param message 错误信息
     */
    public ValidationException(String message) {
        super(ResponseCode.BAD_REQUEST.getCode(), message);
    }

    /**
     * 构造器
     *
     * @param field 校验失败的字段
     * @param message 错误信息
     */
    public ValidationException(String field, String message) {
        super(ResponseCode.BAD_REQUEST.getCode(), field + ": " + message);
    }
}
