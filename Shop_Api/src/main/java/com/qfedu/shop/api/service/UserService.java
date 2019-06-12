package com.qfedu.shop.api.service;

import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserProvider")
public interface UserService {

    @PostMapping("/user/adduser.do")
    public R addUser(@RequestBody User user);

    @GetMapping("/user/findall.do")
    public R selectAll();
}
