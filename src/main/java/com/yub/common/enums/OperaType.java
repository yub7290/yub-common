package com.yub.common.enums;

/**
 * 操作类型枚举
 *
 * @Author: bing.yu
 * @CreateTime: 2026-06-28
 * @Description: 操作类型枚举，用于操作日志记录
 * @Version: 1.0.0
 */
public enum OperaType {

    CREATE("新增"),
    UPDATE("修改"),
    DELETE("删除"),
    QUERY("查询"),
    IMPORT("导入"),
    EXPORT("导出"),
    LOGIN("登录"),
    LOGOUT("登出"),
    OTHER("其他");

    private final String description;

    OperaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
