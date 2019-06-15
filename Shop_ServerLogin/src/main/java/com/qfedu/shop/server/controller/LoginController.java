package com.qfedu.shop.server.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:27 2019/6/14
 * @ Description：登录控制类
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login/login.do")
    public R login(@RequestParam("phone") String phone,@RequestParam("pass") String pass){
        R r = loginService.login(phone, pass);
        return r;
    }

    @PostMapping("/login/checkToken.do")
    public R checkToken(@RequestParam("token") String token){
        R r = loginService.checkLogin(token);
        return r;
    }

    @PostMapping("/login/existLogin.do")
    public R exsitLogin(@RequestParam("token") String token){
        R r = loginService.exitLogin(token);
        return r;
    }

}
