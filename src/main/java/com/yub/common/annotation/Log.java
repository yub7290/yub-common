package com.yub.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 操作日志注解
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 操作描述
     *
     * @return 操作描述
     */
    String value() default "";

    /**
     * 操作类型
     *
     * @return 操作类型（查询/新增/修改/删除）
     */
    String type() default "";
}