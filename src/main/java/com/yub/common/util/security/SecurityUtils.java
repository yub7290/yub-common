package com.yub.common.util.security;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;

import java.nio.charset.StandardCharsets;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 安全工具类
 * @Version: 1.0.0
 */
public final class SecurityUtils {

    /** 私有构造器，禁止实例化 */
    private SecurityUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * MD5 加密
     *
     * @param data 原始数据
     * @return MD5 加密后的字符串（小写）
     */
    public static String md5(String data) {
        if (data == null) {
            return null;
        }
        return SecureUtil.md5(data);
    }

    /**
     * SHA-256 加密
     *
     * @param data 原始数据
     * @return SHA-256 加密后的字符串
     */
    public static String sha256(String data) {
        if (data == null) {
            return null;
        }
        return SecureUtil.sha256(data);
    }

    /**
     * Base64 编码
     *
     * @param data 原始数据
     * @return Base64 编码后的字符串
     */
    public static String base64Encode(String data) {
        if (data == null) {
            return null;
        }
        return Base64.encode(data, StandardCharsets.UTF_8);
    }

    /**
     * Base64 解码
     *
     * @param encodedData Base64 编码的字符串
     * @return 解码后的字符串
     */
    public static String base64Decode(String encodedData) {
        if (encodedData == null) {
            return null;
        }
        return Base64.decodeStr(encodedData, StandardCharsets.UTF_8);
    }

    /**
     * MD5 加盐加密
     *
     * @param data 原始数据
     * @param salt 盐值
     * @return 加盐加密后的字符串
     */
    public static String md5WithSalt(String data, String salt) {
        if (data == null || salt == null) {
            return null;
        }
        return md5(md5(data) + salt);
    }

    /**
     * SHA-256 加盐加密
     *
     * @param data 原始数据
     * @param salt 盐值
     * @return 加盐加密后的字符串
     */
    public static String sha256WithSalt(String data, String salt) {
        if (data == null || salt == null) {
            return null;
        }
        return sha256(sha256(data) + salt);
    }
}