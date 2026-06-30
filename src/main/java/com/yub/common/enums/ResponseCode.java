package com.yub.common.enums;

import com.yub.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 统一响应状态码枚举
 * @Version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ResponseCode implements ErrorCode {

    // ========== 成功 ==========
    /** 操作成功 */
    SUCCESS(200, "操作成功"),

    // ========== 客户端错误 4xx ==========
    /** 请求参数错误 */
    BAD_REQUEST(400, "请求参数错误"),
    /** 未授权 */
    UNAUTHORIZED(401, "未授权"),
    /** 禁止访问 */
    FORBIDDEN(403, "禁止访问"),
    /** 资源未找到 */
    NOT_FOUND(404, "资源未找到"),
    /** 请求方法不支持 */
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),
    /** 请求超时 */
    REQUEST_TIMEOUT(408, "请求超时"),

    // ========== 服务器错误 5xx ==========
    /** 服务器内部错误 */
    INTERNAL_ERROR(500, "服务器内部错误"),
    /** 服务不可用 */
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    /** 网关超时 */
    GATEWAY_TIMEOUT(504, "网关超时"),

    // ========== 业务错误 1xxx ==========
    /** 业务处理失败 */
    BUSINESS_ERROR(1000, "业务处理失败"),
    /** 数据不存在 */
    DATA_NOT_FOUND(1001, "数据不存在"),
    /** 数据已存在 */
    DATA_ALREADY_EXISTS(1002, "数据已存在"),
    /** 操作频率限制 */
    RATE_LIMIT_EXCEEDED(1003, "操作频率限制"),
    /** 防重复提交 */
    DUPLICATE_REQUEST(1004, "请勿重复提交"),
    /** 文件大小超过限制 */
    FILE_SIZE_EXCEEDED(1005, "文件大小超过限制"),
    /** 文件类型不允许 */
    FILE_TYPE_NOT_ALLOWED(1006, "文件类型不允许"),

    // ========== 系统错误 5xxx ==========
    /** 系统繁忙 */
    SYSTEM_BUSY(5000, "系统繁忙，请稍后重试"),
    /** 数据库错误 */
    DATABASE_ERROR(5001, "数据库错误"),
    /** 缓存错误 */
    CACHE_ERROR(5002, "缓存错误");

    /** 状态码 */
    private final int code;

    /** 状态信息 */
    private final String message;
}