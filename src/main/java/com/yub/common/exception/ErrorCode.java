package com.yub.common.exception;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-06-10
 * @Description: 异常错误枚举
 * @Version: 1.0
 */
public interface ErrorCode {

    /**
     * 获取错误码
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误消息
     * @return 错误消息
     */
    String getMessage();

}
