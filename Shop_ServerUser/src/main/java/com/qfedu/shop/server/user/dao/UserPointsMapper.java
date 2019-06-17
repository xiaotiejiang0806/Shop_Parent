package com.qfedu.shop.server.user.dao;


import com.qfedu.shop.entity.UserPoints;
import org.apache.ibatis.annotations.Param;

public interface UserPointsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPoints record);

    int insertSelective(UserPoints record);

    UserPoints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPoints record);

    int updateByPrimaryKey(UserPoints record);

    int updatePoints(@Param("uid") int uid,@Param("score") int score);
}