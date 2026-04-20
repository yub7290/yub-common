package com.yub.common.constant;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 日期格式常量
 * @Version: 1.0.0
 */
public final class DateConstants {

    /** 私有构造器，禁止实例化 */
    private DateConstants() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    // ========== 常用日期格式 ==========

    /** 年-月-日 */
    public static final String PATTERN_DATE = "yyyy-MM-dd";

    /** 年-月-日 时:分:秒 */
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /** 年-月-日 时:分:秒.毫秒 */
    public static final String PATTERN_DATETIME_MS = "yyyy-MM-dd HH:mm:ss.SSS";

    /** 年-月 */
    public static final String PATTERN_YEAR_MONTH = "yyyy-MM";

    /** 年 */
    public static final String PATTERN_YEAR = "yyyy";

    /** 月-日 */
    public static final String PATTERN_MONTH_DAY = "MM-dd";

    /** 时:分:秒 */
    public static final String PATTERN_TIME = "HH:mm:ss";

    /** 时:分 */
    public static final String PATTERN_TIME_SHORT = "HH:mm";

    /** 时间戳（秒） */
    public static final String PATTERN_TIMESTAMP = "yyyyMMddHHmmss";

    /** 时间戳（毫秒） */
    public static final String PATTERN_TIMESTAMP_MS = "yyyyMMddHHmmssSSS";

    /** 中文日期格式 */
    public static final String PATTERN_DATE_CN = "yyyy年MM月dd日";

    /** 中文日期时间格式 */
    public static final String PATTERN_DATETIME_CN = "yyyy年MM月dd日 HH时mm分ss秒";
}