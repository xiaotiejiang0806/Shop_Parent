package com.qfedu.shop.loginapi.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;
import com.qfedu.shop.entity.UserDetail;
import com.qfedu.shop.loginapi.service.UserService;
import com.qfedu.shop.loginapi.util.DateConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api(value = "用户相关操作",tags = "用户相关操作")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
   private DateConverter dateConverter;

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

    @ApiOperation(value = "更新密码",notes = "更新密码")
    @PostMapping("/api/updatePass.do")
    public R updatePass(String token, String pass){
        R r = userService.updatePass(token, pass);
        return r;
    }
    @ApiOperation(value = "更新用户详情",notes = "更新用户详情")
    @PostMapping("/api/updateInfo.do")
    public R updateDet(String token,UserDetail userDetail){
        R r = userService.updateDet(token,userDetail);
        return r;
    }

    @InitBinder
    public void initbind(WebDataBinder binder) {
        // 注册自定义的编辑器
        // 第一个参数：要转换成的类型
        // 第二个参数：自定义编辑器
        binder.registerCustomEditor(Date.class,
                // 第一个参数：日期格式对象
                // 第二个参数：是否允许为空
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
