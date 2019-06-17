package com.qfedu.shop.server.user.dao;


import com.qfedu.shop.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> all();

    User findUserByPhone(String phone);

    int updatePass(@Param("id") int id,@Param("pass") String pass);
}