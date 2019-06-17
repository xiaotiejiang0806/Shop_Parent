package com.qfedu.shop.loginapi.controller;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.vo.R;
import com.qfedu.shop.loginapi.service.UserSinginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 21:25 2019/6/15
 * @ Description：${description}
 */
@RestController
@Api(value = "签到相关",tags = "签到相关操作")
public class UserSinginController {

    @Autowired
    private UserSinginService userSingnService;


    @PostMapping("/Api/usersingn/save.do")
    @ApiOperation(value = "签到",notes = "签到操作")
    public R save (HttpServletRequest request){
        R r = userSingnService.save(request.getHeader(ProjectConfig.TOKENHEAD));
        return r;
    }

    @GetMapping("/Api/usersingn/querrydays.do")
    @ApiOperation(value = "查询签到记录",notes = "查询天数以内的签到记录")
    public R querryByDays(HttpServletRequest request,@RequestParam("days") int days){
        R r = userSingnService.querryByDays(request.getHeader(ProjectConfig.TOKENHEAD), days);
        return r;
    }

    @ApiOperation(value = "查询所有的签到记录", notes = "查询用户所有的签到记录")
    @GetMapping("/Api/usersingn/querryAll.do")
    public R querryAll(HttpServletRequest request) {
        R r = userSingnService.querryAll(request.getHeader(ProjectConfig.TOKENHEAD));
        return r;
    }

    @ApiOperation(value = "查看最近一次签到",notes = "查看最近一次签到的记录")
    @GetMapping("/Api/usersingn/querrySingle.do")
    public R querrySingle(HttpServletRequest request){
        R r = userSingnService.querrySingle(request.getHeader(ProjectConfig.TOKENHEAD));
        return r;
    }
}
