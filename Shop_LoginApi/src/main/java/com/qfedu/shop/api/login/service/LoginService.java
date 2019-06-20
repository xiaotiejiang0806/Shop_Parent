package com.qfedu.shop.api.login.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:41 2019/6/14
 */
@FeignClient(name = "LoginProvider")
public interface LoginService {

    @PostMapping("/login/login.do")
    public R login(@RequestParam("phone") String phone, @RequestParam("pass") String pass);

    @PostMapping("/login/checkToken.do")
    public R checkToken(@RequestParam("token") String token);

    @PostMapping("/login/existLogin.do")
    public R exsitLogin(@RequestParam("token") String token);


}
