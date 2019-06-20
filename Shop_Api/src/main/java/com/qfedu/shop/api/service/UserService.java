package com.qfedu.shop.api.service;

import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;
import com.qfedu.shop.entity.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:43 2019/6/20
 * @ Description：${description}
 */
@FeignClient(name = "UserProvider")
public interface UserService {

    @PostMapping("/user/adduser.do")
    public R addUser(@RequestBody User user);

    @GetMapping("/user/findall.do")
    public R selectAll();

    @GetMapping("/user/checkphone.do")
    public R check(@RequestParam String phone);

    @PostMapping("/user/updatePass.do")
    public R updatePass(@RequestParam("token") String token,@RequestParam("pass") String pass);

    @PostMapping("/user/updateInfo.do")
    public R updateDet(@RequestParam("token") String token,@RequestBody UserDetail userDetail);
}
