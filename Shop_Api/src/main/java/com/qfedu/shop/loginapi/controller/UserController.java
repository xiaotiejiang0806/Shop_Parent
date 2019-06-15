package com.qfedu.shop.loginapi.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.loginapi.service.UserService;
import com.qfedu.shop.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户相关操作",tags = "用户相关操作")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加一个新用户",notes = "添加一个新用户并初始化相关参数")
    @PostMapping("/api/adduser.do")
    public R addUser(User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "查询所有的用户",notes = "查询所有的用户")
    @GetMapping("/api/findAll.do")
    public R all(){
        return userService.selectAll();
    }

    @ApiOperation(value = "核对手机号",notes = "核对手机号是否已经使用")
    @GetMapping("/api/checkphone.do")
    public R checkPhone(String phone){
      return   userService.check(phone);
    }
}
