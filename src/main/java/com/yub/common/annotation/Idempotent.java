package com.yub.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 防重复提交注解
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotent {

    /**
     * 防重复提交 key
     *
     * @return key（支持 SpEL 表达式）
     */
    String key() default "";

    /**
     * 锁定时间（秒）
     *
     * @return 锁定时间，默认 10 秒
     */
    int lockTime() default 10;

    /**
     * 错误消息
     *
     * @return 错误消息
     */
    String message() default "请勿重复提交";
}
