package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {

    int insert(GoodsType record);

    List<GoodsType>selectByLevel (int level);

    List<GoodsType> findAll();
}