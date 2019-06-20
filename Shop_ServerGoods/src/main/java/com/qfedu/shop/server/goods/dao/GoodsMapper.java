package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.Goods;
import com.qfedu.shop.server.goods.dto.GoodsDetailDto;
import com.qfedu.shop.server.goods.dto.GoodsListDto;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    int insert(Goods record);


    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll(Map<String,Object> param);

    List<GoodsListDto> findGoodList(Map<String,Object> map);

    GoodsDetailDto findGoodsDetail(int id);
}