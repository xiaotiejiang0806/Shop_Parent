package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.GoodsDetail;

public interface GoodsDetailMapper {

    int insert(GoodsDetail record);

   GoodsDetail findByGid(int gid);

}