package com.yub.common.util.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 集合工具类
 * @Version: 1.0.0
 */
public final class CollectionUtils {

    /** 私有构造器，禁止实例化 */
    private CollectionUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollUtil.isEmpty(collection);
    }

    /**
     * 判断集合是否不为空
     *
     * @param collection 集合
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return CollUtil.isNotEmpty(collection);
    }

    /**
     * 判断 Map 是否为空
     *
     * @param map Map
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return CollUtil.isEmpty(map);
    }

    /**
     * 判断 Map 是否不为空
     *
     * @param map Map
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return CollUtil.isNotEmpty(map);
    }

    /**
     * 获取集合第一个元素
     *
     * @param list 集合
     * @param <T> 元素类型
     * @return 第一个元素，没有则返回 null
     */
    public static <T> T getFirst(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 获取集合最后一个元素
     *
     * @param list 集合
     * @param <T> 元素类型
     * @return 最后一个元素，没有则返回 null
     */
    public static <T> T getLast(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /**
     * 集合是否包含空元素
     *
     * @param collection 集合
     * @return 是否包含空元素
     */
    public static boolean hasEmpty(Collection<?> collection) {
        if (isEmpty(collection)) {
            return true;
        }
        for (Object item : collection) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 集合是否全部非空
     *
     * @param collection 集合
     * @return 是否全部非空
     */
    public static boolean isAllNotEmpty(Collection<?> collection) {
        return !hasEmpty(collection);
    }
}