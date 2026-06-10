package com.yub.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 删除状态枚举
 * @Version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DeleteEnum {

    /** 已删除 */
    DELETED(1, "已删除"),

    /** 未删除 */
    NORMAL(0, "未删除");

    /** 状态值 */
    private final int code;

    /** 状态描述 */
    private final String name;
}