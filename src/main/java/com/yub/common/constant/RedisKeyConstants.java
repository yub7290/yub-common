package com.yub.common.constant;

/**
 * Redis Key 前缀常量
 *
 * @Author: bing.yu
 * @CreateTime: 2026-06-10
 * @Description: 统一管理 Redis Key 前缀，避免分散在各模块中
 * @Version: 1.0.0
 */
public final class RedisKeyConstants {

    private RedisKeyConstants() {
    }

    /** 验证码 Key 前缀 */
    public static final String CAPTCHA_PREFIX = "captcha:";
    /** Refresh Token Key 前缀 */
    public static final String REFRESH_TOKEN_PREFIX = "refresh_token:";
    /** Token 黑名单 Key 前缀 */
    public static final String TOKEN_BLACKLIST_PREFIX = "token_blacklist:";
}
