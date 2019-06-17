package com.qfedu.shop.server.user.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.server.user.service.UserSingnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 21:14 2019/6/15
 * @ Description：${description}
 */

@RestController
public class UserSinginController {

    @Autowired
    private UserSingnService userSingnService;

    @PostMapping("/usersingn/save.do")
    public R save (@RequestParam("token") String token){
        R r = userSingnService.saveSingn(token);
        return r;
    }
    @GetMapping("/usersingn/querrydays.do")
    public R querryByDays(@RequestParam("token") String token,@RequestParam("days") int days){
        R r = userSingnService.querryByDays(token, days);
        return r;
    }
    @GetMapping("/usersingn/querryAll.do")
    public R querryAll(@RequestParam("token") String token) {
        R r = userSingnService.querryByUid(token);
        return r;
    }

    @GetMapping("/usersingn/querrySingle.do")
    public R querrySingle(@RequestParam("token") String token){
        R r = userSingnService.querrySingle(token);
        return r;
    }
}
