package com.qfedu.shop.server.user.dao;

import com.qfedu.shop.entity.UserSign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:40 2019/6/15
 * @ Description：${description}
 */
@Repository
public interface UserSignDao {

    int insert (UserSign userSign);

    List<UserSign> selectByUid(int uid);

    UserSign selectByUidLast(int uid);

    List<UserSign> selectVByDateAndUid(@Param("days") int days,@Param("uid") int uid);

}
