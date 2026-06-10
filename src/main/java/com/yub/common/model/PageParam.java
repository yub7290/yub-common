package com.yub.common.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-07
 * @Description: 分页参数
 * @Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int pageNum = 1;

    private int pageSize = 10;

    /**
     * 排序字段，格式：field1 asc,field2 desc
     */
    private String orderBy;
}
