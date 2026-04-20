package com.yub.common.enums;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 删除状态枚举
 * @Version: 1.0.0
 */
public enum DeleteStatus {

    /** 已删除 */
    DELETED(1, "已删除"),

    /** 未删除 */
    NORMAL(0, "未删除");

    /** 状态值 */
    private final int value;

    /** 状态描述 */
    private final String description;

    DeleteStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    /**
     * 获取状态值
     *
     * @return 状态值
     */
    public int getValue() {
        return value;
    }

    /**
     * 获取状态描述
     *
     * @return 状态描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 根据值获取枚举
     *
     * @param value 状态值
     * @return 删除状态枚举
     */
    public static DeleteStatus fromValue(int value) {
        for (DeleteStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown delete status value: " + value);
    }
}