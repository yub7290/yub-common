package com.yub.common.util.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.*;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 函数式工具类
 * @Version: 1.0.0
 */
public final class FunctionUtils {

    private static final Logger log = LoggerFactory.getLogger(FunctionUtils.class);

    /** 私有构造器，禁止实例化 */
    private FunctionUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 空操作消费者
     *
     * @param <T> 输入类型
     * @return 空操作消费者
     */
    public static <T> Consumer<T> noopConsumer() {
        return t -> {};
    }

    /**
     * 空操作函数
     *
     * @param <T> 输入类型
     * @param <R> 输出类型
     * @return 空操作函数
     */
    public static <T, R> Function<T, R> noopFunction() {
        return t -> null;
    }

    /**
     * 空操作供应者
     *
     * @param <T> 输出类型
     * @return 空操作供应者
     */
    public static <T> Supplier<T> noopSupplier() {
        return () -> null;
    }

    /**
     * 安全的消费者（异常记录日志）
     *
     * @param consumer 消费者
     * @param <T> 输入类型
     * @return 安全包装后的消费者
     */
    public static <T> Consumer<T> safeConsumer(Consumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                log.error("Safe consumer execution failed", e);
            }
        };
    }

    /**
     * 安全的消费者（异常自定义处理）
     *
     * @param consumer 消费者
     * @param errorHandler 异常处理器
     * @param <T> 输入类型
     * @return 安全包装后的消费者
     */
    public static <T> Consumer<T> safeConsumer(Consumer<T> consumer, Consumer<Exception> errorHandler) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                errorHandler.accept(e);
            }
        };
    }

    /**
     * 安全的函数
     *
     * @param function 函数
     * @param defaultValue 默认值
     * @param <T> 输入类型
     * @param <R> 输出类型
     * @return 安全包装后的函数
     */
    public static <T, R> Function<T, R> safeFunction(Function<T, R> function, R defaultValue) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception e) {
                return defaultValue;
            }
        };
    }

    /**
     * 组合两个函数
     *
     * @param first 第一个函数
     * @param second 第二个函数
     * @param <T> 输入类型
     * @param <M> 中间类型
     * @param <R> 输出类型
     * @return 组合后的函数
     */
    public static <T, M, R> Function<T, R> compose(Function<T, M> first, Function<M, R> second) {
        return t -> second.apply(first.apply(t));
    }

    /**
     * 谓词取反
     *
     * @param predicate 谓词
     * @param <T> 类型
     * @return 取反后的谓词
     */
    public static <T> Predicate<T> negate(Predicate<T> predicate) {
        return predicate.negate();
    }
}