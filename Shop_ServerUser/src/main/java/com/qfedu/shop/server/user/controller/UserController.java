package com.qfedu.shop.server.user.controller;

import com.qfedu.common.execption.UserException;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;
import com.qfedu.shop.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/adduser.do")
    public R addUser(@RequestBody User user) throws UserException {
        return userService.addUser(user);
    }

    @GetMapping("/user/findall.do")
    public R selectAll(){
        R all = userService.all();
        return all;
    }
}