package com.yub.common.util.reflect;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 反射工具类
 * @Version: 1.0.0
 */
public final class ReflectUtils {

    /** 私有构造器，禁止实例化 */
    private ReflectUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 获取字段值
     *
     * @param target 目标对象
     * @param fieldName 字段名
     * @return 字段值
     */
    public static Object getFieldValue(Object target, String fieldName) {
        Field field = ReflectUtil.getField(target.getClass(), fieldName);
        if (field == null) {
            return null;
        }
        return ReflectUtil.getFieldValue(target, field);
    }

    /**
     * 设置字段值
     *
     * @param target 目标对象
     * @param fieldName 字段名
     * @param value 字段值
     */
    public static void setFieldValue(Object target, String fieldName, Object value) {
        Field field = ReflectUtil.getField(target.getClass(), fieldName);
        if (field != null) {
            ReflectUtil.setFieldValue(target, field, value);
        }
    }

    /**
     * 获取字段
     *
     * @param clazz 类
     * @param fieldName 字段名
     * @return 字段
     */
    public static Field getField(Class<?> clazz, String fieldName) {
        return ReflectUtil.getField(clazz, fieldName);
    }

    /**
     * 获取所有字段
     *
     * @param clazz 类
     * @return 字段数组
     */
    public static Field[] getFields(Class<?> clazz) {
        return ReflectUtil.getFields(clazz);
    }

    /**
     * 调用方法
     *
     * @param target 目标对象
     * @param methodName 方法名
     * @param params 参数
     * @return 方法返回值
     */
    public static Object invoke(Object target, String methodName, Object... params) {
        return ReflectUtil.invoke(target, methodName, params);
    }

    /**
     * 获取方法
     *
     * @param clazz 类
     * @param methodName 方法名
     * @param paramTypes 参数类型
     * @return 方法
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        return ReflectUtil.getMethod(clazz, methodName, paramTypes);
    }

    /**
     * 获取所有方法
     *
     * @param clazz 类
     * @return 方法数组
     */
    public static Method[] getMethods(Class<?> clazz) {
        return ReflectUtil.getMethods(clazz);
    }

    /**
     * 创建实例
     *
     * @param clazz 类
     * @param params 构造参数
     * @param <T> 类型
     * @return 实例
     */
    public static <T> T newInstance(Class<T> clazz, Object... params) {
        return ReflectUtil.newInstance(clazz, params);
    }
}
