package com.ydles.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Project Name: ydles_parent
 * File Name: Page
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/05/上午 10:30
 * Copyright (c) 2022,
 */
public class Page<T> implements Serializable {
    //当前默认为第一页
    public static final Integer pageNum=1;
    //默认每页显示条件
    public static final Integer pageSize=20;
    public static  final Integer cpm(Integer pageNum){
        if (null==pageNum||pageNum<1) {
            pageNum=1;
        }
        return pageNum;
    }

    public static Integer getPageNum() {
        return pageNum;
    }

    public static Integer getPageSize() {
        return pageSize;
    }
}
