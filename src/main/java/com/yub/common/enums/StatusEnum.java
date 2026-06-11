package com.yub.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @Author: bing.yu
 * @CreateTime: 2026-06-10
 * @Description: 用户启用/禁用状态
 * @Version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    /**
     * 禁用
     */
    DISABLED(0, "禁用"),
    /**
     * 正常
     */
    ENABLED(1, "启用");

    private final int code;
    private final String desc;

    /**
     * 判断是否被禁用
     *
     * @param status 状态值
     * @return true=已禁用
     */
    public static boolean isDisabled(Integer status) {
        return status != null && status == DISABLED.code;
    }
}
