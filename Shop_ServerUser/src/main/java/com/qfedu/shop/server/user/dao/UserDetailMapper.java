package com.qfedu.shop.server.user.dao;


import com.qfedu.shop.entity.UserDetail;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);

    int insertinituser(int uid);

    int updateByUidSelective(UserDetail userDetail);
}