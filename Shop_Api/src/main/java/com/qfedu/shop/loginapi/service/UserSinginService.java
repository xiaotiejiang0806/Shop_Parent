package com.qfedu.shop.loginapi.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 21:24 2019/6/15
 * @ Description：${description}
 */
@FeignClient(name = "UserProvider")
public interface UserSinginService {

    @PostMapping("/usersingn/save.do")
    public R save (@RequestParam("token") String token);

    @GetMapping("/usersingn/querrydays.do")
    public R querryByDays(@RequestParam("token") String token,@RequestParam("days") int days);

    @GetMapping("/usersingn/querryAll.do")
    public R querryAll(@RequestParam("token") String token);

    @GetMapping("/usersingn/querrySingle.do")
    public R querrySingle(@RequestParam("token") String token);
}
