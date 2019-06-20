package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeMapper {


    int insertSelective(String name);

    GoodsAttribute selectByPrimaryKey(Integer id);

    List<GoodsAttribute> findAll();

}