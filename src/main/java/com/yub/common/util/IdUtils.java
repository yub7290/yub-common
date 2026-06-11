package com.yub.common.util;

import java.util.UUID;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-06-11
 * @Description: ID工具类
 * @Version: 1.0
 */
public class IdUtils {

    /**
     * 生成UUID
     * @return UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成简单UUID
     * @return 简单UUID
     */
    public static String simpleUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
