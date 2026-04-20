package com.yub.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 异步执行注解
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Async {

    /**
     * 异步任务名称
     *
     * @return 任务名称
     */
    String value() default "";

    /**
     * 核心线程数
     *
     * @return 核心线程数
     */
    int corePoolSize() default 0;

    /**
     * 最大线程数
     *
     * @return 最大线程数
     */
    int maxPoolSize() default 0;

    /**
     * 队列容量
     *
     * @return 队列容量
     */
    int queueCapacity() default 0;
}
