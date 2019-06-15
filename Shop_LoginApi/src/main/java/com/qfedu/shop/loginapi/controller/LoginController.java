package com.qfedu.shop.loginapi.controller;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.vo.R;
import com.qfedu.shop.loginapi.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:43 2019/6/14
 * @ Description：${description}
 */
@RestController
@Api(value = "统一登录中心",tags = "提供统一的登录验证以及TOKEN生成")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录验证",notes = "登录验证以及TOKEN令牌生成")
    @PostMapping("/login/login.do")
    public R login(String phone, String pass){
        R r = loginService.login(phone, pass);
        return r;
    }

    @ApiOperation(value = "检查Token",notes = "检查token令牌的合法性")
    @PostMapping("/login/checkToken.do")
    public R checkToken(HttpServletRequest request){
        R r = loginService.checkToken(request.getHeader(ProjectConfig.TOKENHEAD));
        return r;
    }

    @ApiOperation(value = "退出",notes = "退出当前程序")
    @PostMapping("/login/existLogin.do")
    public R exsitLogin( String token){
        R r = loginService.exsitLogin(token);
        return r;
    }
}
