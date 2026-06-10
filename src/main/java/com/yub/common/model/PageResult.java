package com.yub.common.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 *
 * @param <T> 记录类型
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 当前页数据 */
    private List<T> records;

    /** 当前页码 */
    private int pageNum;

    /** 每页记录数 */
    private int pageSize;

    /** 总页数 */
    private int pages;

    /**
     * 创建分页结果
     *
     * @param records 当前页数据
     * @param total   总记录数
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @param <T>     记录类型
     * @return 分页结果
     */
    public static <T> PageResult<T> of(List<T> records, long total, int pageNum, int pageSize) {
        return PageResult.<T>builder()
                .records(records)
                .total(total)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .pages(calculatePages(total, pageSize))
                .build();
    }

    /**
     * 计算总页数
     *
     * @param total   总记录数
     * @param pageSize 每页记录数
     * @return 总页数
     */
    private static int calculatePages(long total, int pageSize) {
        if (pageSize <= 0) {
            return 0;
        }
        return (int) ((total + pageSize - 1) / pageSize);
    }
}