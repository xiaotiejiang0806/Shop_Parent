package com.qfedu.shop.server.user.util;

import com.alibaba.fastjson.JSON;
import com.qfedu.shop.entity.User;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 19:31 2019/6/15
 */
public class UserTokenUtil {

    public static User parseToken(String json){
        if (json != null){
            return JSON.parseObject(json, User.class);
        }else {
            return null;
        }
    }

    public static int parseTokenId (String json){
        if (json != null){
            User user = JSON.parseObject(json, User.class);
            return user.getId();
        }else {
            return 0;
        }
    }


}
