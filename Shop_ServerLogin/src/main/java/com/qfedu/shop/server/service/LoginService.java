package com.qfedu.shop.server.service;

import com.qfedu.common.vo.R;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:30 2019/6/14
 */
public interface LoginService {


    R login (String phone,String pass);

    R checkLogin(String token);

    R exitLogin(String token);
}
