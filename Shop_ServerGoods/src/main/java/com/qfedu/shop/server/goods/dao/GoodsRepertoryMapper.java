package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.GoodsRepertory;
import org.apache.ibatis.annotations.Param;

public interface GoodsRepertoryMapper {

    int insert(GoodsRepertory record);

    int updateCount(@Param("id") int id,@Param("count") int count);


}