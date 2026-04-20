package com.yub.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 分页模型
 * @Version: 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 1L;

    /** 当前页码（从 1 开始） */
    private long current;

    /** 每页大小 */
    private long size;

    /** 总记录数 */
    private long total;

    /** 总页数 */
    private long pages;

    /** 分页数据 */
    private List<T> records;

    /**
     * 创建空分页对象
     *
     * @param <T> 数据类型
     * @return 空分页对象
     */
    public static <T> Page<T> empty() {
        return Page.<T>builder()
                .current(1)
                .size(10)
                .total(0)
                .pages(0)
                .records(List.of())
                .build();
    }

    /**
     * 创建分页对象
     *
     * @param current 当前页码
     * @param size 每页大小
     * @param total 总记录数
     * @param records 分页数据
     * @param <T> 数据类型
     * @return 分页对象
     */
    public static <T> Page<T> of(long current, long size, long total, List<T> records) {
        long pages = total % size == 0 ? total / size : total / size + 1;
        return Page.<T>builder()
                .current(current)
                .size(size)
                .total(total)
                .pages(pages)
                .records(records)
                .build();
    }
}
