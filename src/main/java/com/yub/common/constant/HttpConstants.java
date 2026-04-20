package com.yub.common.constant;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: HTTP 相关常量
 * @Version: 1.0.0
 */
public final class HttpConstants {

    /** 私有构造器，禁止实例化 */
    private HttpConstants() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    // ========== HTTP 状态码 ==========

    /** 成功 */
    public static final int HTTP_OK = 200;

    /** 创建成功 */
    public static final int HTTP_CREATED = 201;

    /** 无内容 */
    public static final int HTTP_NO_CONTENT = 204;

    /** 永久重定向 */
    public static final int HTTP_MOVED_PERM = 301;

    /** 临时重定向 */
    public static final int HTTP_FOUND = 302;

    /** 客户端错误 */
    public static final int HTTP_BAD_REQUEST = 400;

    /** 未授权 */
    public static final int HTTP_UNAUTHORIZED = 401;

    /** 禁止访问 */
    public static final int HTTP_FORBIDDEN = 403;

    /** 未找到 */
    public static final int HTTP_NOT_FOUND = 404;

    /** 服务器内部错误 */
    public static final int HTTP_INTERNAL_ERROR = 500;

    // ========== Header 名称 ==========

    /** 内容类型 */
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    /** 内容长度 */
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";

    /** 内容编码 */
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";

    /** 请求 ID（链路追踪） */
    public static final String HEADER_REQUEST_ID = "X-Request-Id";

    /** 用户代理 */
    public static final String HEADER_USER_AGENT = "User-Agent";

    /** 授权信息 */
    public static final String HEADER_AUTHORIZATION = "Authorization";

    // ========== Content-Type ==========

    /** JSON */
    public static final String CONTENT_TYPE_JSON = "application/json";

    /** XML */
    public static final String CONTENT_TYPE_XML = "application/xml";

    /** 表单 */
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";

    /** Multipart */
    public static final String CONTENT_TYPE_MULTIPART = "multipart/form-data";

    /** 文本 */
    public static final String CONTENT_TYPE_TEXT = "text/plain";

    /** HTML */
    public static final String CONTENT_TYPE_HTML = "text/html";
}