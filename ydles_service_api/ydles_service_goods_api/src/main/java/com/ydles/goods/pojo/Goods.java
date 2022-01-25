package com.ydles.goods.pojo;

/**
 * Project Name: ydles_parent
 * File Name: Goods
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/21/上午 8:36
 * Copyright (c) 2022,
 */

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合实体类
 */
public class Goods implements Serializable {

    private Spu spu;
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", skuList=" + skuList +
                '}';
    }
}
