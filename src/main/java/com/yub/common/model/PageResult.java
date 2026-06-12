package com.yub.common.model;

import lombok.*;

import java.io.Serial;
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

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 当前页数据
     */
    private List<T> records;

    /**
     * 创建分页结果
     *
     * @param records 当前页数据
     * @param total   总记录数
     * @param <T>     记录类型
     * @return 分页结果
     */
    public static <T> PageResult<T> of(List<T> records, long total) {
        return PageResult.<T>builder()
                .records(records)
                .total(total)
                .build();
    }
}