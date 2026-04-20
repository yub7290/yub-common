package com.yub.common.util.date;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 日期工具类
 * @Version: 1.0.0
 */
public final class DateUtils {

    /** 私有构造器，禁止实例化 */
    private DateUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static LocalDateTime nowDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 格式化日期
     *
     * @param date 日期
     * @param pattern 格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return DateUtil.format(date, pattern);
    }

    /**
     * 格式化日期时间
     *
     * @param dateTime 日期时间
     * @param pattern 格式
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(java.time.format.DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 解析日期字符串
     *
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return 日期
     * @throws ParseException 解析异常
     */
    public static Date parse(String dateStr, String pattern) throws ParseException {
        return DateUtil.parse(dateStr, pattern);
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime LocalDateTime
     * @return Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断是否过期
     *
     * @param date 日期
     * @return 是否过期
     */
    public static boolean isExpired(Date date) {
        if (date == null) {
            return true;
        }
        return date.before(now());
    }

    /**
     * 计算两个日期之间的天数
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 天数
     */
    public static long daysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        long diff = endDate.getTime() - startDate.getTime();
        return diff / (1000 * 60 * 60 * 24);
    }
}