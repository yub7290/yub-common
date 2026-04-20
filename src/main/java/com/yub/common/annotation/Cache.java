package com.yub.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 缓存注解
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    /**
     * 缓存 key
     *
     * @return 缓存 key（支持 SpEL 表达式）
     */
    String key();

    /**
     * 过期时间（秒）
     *
     * @return 过期时间，默认 -1 表示永不过期
     */
    long expire() default -1;

    /**
     * 缓存描述
     *
     * @return 缓存描述
     */
    String description() default "";
}
