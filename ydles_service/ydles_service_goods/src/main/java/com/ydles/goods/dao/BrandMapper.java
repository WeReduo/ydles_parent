package com.ydles.goods.dao;

import com.ydles.goods.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BrandMapper extends Mapper<Brand> {
    /**
                * 根据分类名称查询品牌列表
                * @param categoryName
                * @return
                */
    @Select("SELECT name,img FROM tb_brand WHERE id  IN (SELECT brand_id FROM tb_category_brand WHERE  category_id IN (SELECT id FROM tb_category WHERE NAME=#{name}) )order by seq")
    public List<Map> findCategoryName(@Param("name") String categoryName);
}
