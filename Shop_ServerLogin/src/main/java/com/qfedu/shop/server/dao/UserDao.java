package com.qfedu.shop.server.dao;

import com.qfedu.shop.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:28 2019/6/14
 */
public interface UserDao {

    @Select("select * from user where phone = #{phone} and flag =1")
    public User findUser(String phone);
}
