package com.yub.common.util.string;

import cn.hutool.core.util.StrUtil;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 字符串工具类
 * @Version: 1.0.0
 */
public final class StringUtils {

    /** 私有构造器，禁止实例化 */
    private StringUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return StrUtil.isEmpty(str);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return StrUtil.isNotEmpty(str);
    }

    /**
     * 判断字符串是否为空（包含空白字符）
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isBlank(String str) {
        return StrUtil.isBlank(str);
    }

    /**
     * 判断字符串是否不为空（包含空白字符）
     *
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotBlank(String str) {
        return StrUtil.isNotBlank(str);
    }

    /**
     * 字符串格式化
     *
     * @param template 模板
     * @param params 参数
     * @return 格式化后的字符串
     */
    public static String format(String template, Object... params) {
        return StrUtil.format(template, params);
    }

    /**
     * 字符串脱敏（手机号）
     *
     * @param phone 手机号
     * @return 脱敏后的手机号
     */
    public static String maskPhone(String phone) {
        if (isEmpty(phone)) {
            return "";
        }
        if (phone.length() != 11) {
            return phone;
        }
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    /**
     * 字符串脱敏（身份证）
     *
     * @param idCard 身份证号
     * @return 脱敏后的身份证号
     */
    public static String maskIdCard(String idCard) {
        if (isEmpty(idCard)) {
            return "";
        }
        if (idCard.length() < 8) {
            return idCard;
        }
        return idCard.substring(0, 4) + "**********" + idCard.substring(idCard.length() - 4);
    }

    /**
     * 字符串脱敏（邮箱）
     *
     * @param email 邮箱
     * @return 脱敏后的邮箱
     */
    public static String maskEmail(String email) {
        if (isEmpty(email)) {
            return "";
        }
        int atIndex = email.indexOf("@");
        if (atIndex <= 1) {
            return email;
        }
        return email.substring(0, 2) + "***" + email.substring(atIndex);
    }

    /**
     * 驼峰转下划线
     *
     * @param camelCase 驼峰字符串
     * @return 下划线字符串
     */
    public static String camelToUnderline(String camelCase) {
        if (isEmpty(camelCase)) {
            return "";
        }
        String result = camelCase.replaceAll("([A-Z])", "_$1").toLowerCase();
        return result.startsWith("_") ? result.substring(1) : result;
    }

    /**
     * 下划线转驼峰
     *
     * @param underline 下划线字符串
     * @return 驼峰字符串
     */
    public static String underlineToCamel(String underline) {
        if (isEmpty(underline)) {
            return "";
        }
        return underline.replaceAll("_([a-z])", "$1").toLowerCase();
    }
}