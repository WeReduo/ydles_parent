package com.ydles.entity;

import java.util.List;

/**
 * Project Name: ydles_parent
 * File Name: PageResult
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/05/上午 10:30
 * Copyright (c) 2022,
 */
public class PageResult<T> {
    private Long total;//总记录数
    private List<T> rows;//记录
    public PageResult(Long total, List<T>rows) {
        this.total=total;
        this.rows=rows;


        }
    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

