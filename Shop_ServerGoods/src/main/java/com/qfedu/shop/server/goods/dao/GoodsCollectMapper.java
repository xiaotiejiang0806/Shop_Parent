package com.qfedu.shop.server.goods.dao;

import com.qfedu.shop.entity.GoodsCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCollectMapper {
    int deleteByUidAndGid(@Param("gid") Integer gid,@Param("uid") Integer uid);

    int insert(GoodsCollect record);

    List<GoodsCollect> findAll(int uid);

}