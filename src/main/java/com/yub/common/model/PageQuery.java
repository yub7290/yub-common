package com.yub.common.model;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-07
 * @Description: 分页查询包装类
 * @Version: 1.0
 */
@Getter
public class PageQuery<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 业务查询条件
     */
    private T queryParam;

    /**
     * 分页参数
     */
    private PageParam pageParam;
}
