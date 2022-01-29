package com.ydles.goods.feign;

import com.ydles.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Project Name: ydles_parent
 * File Name: SkuFeign
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/29/上午 10:23
 * Copyright (c) 2022,
 */
@FeignClient(name = "goods")
public interface SkuFeign {

    //根据spuId查询skuList
    @GetMapping("/sku/spu/{spuId}")
    public List<Sku> findSkuListBySpuId(@PathVariable("spuId")String spuId);
}