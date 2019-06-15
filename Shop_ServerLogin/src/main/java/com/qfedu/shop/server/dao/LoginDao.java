package com.qfedu.shop.server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:28 2019/6/14
 * @ Description：${description}
 */
public interface LoginDao {

    @Insert("insert into userlog (uid,flag,content,createtime) values(#{uid},2,#{content},now())")
    public int saveLog (@Param("uid") int uid,@Param("content") String content);
}
