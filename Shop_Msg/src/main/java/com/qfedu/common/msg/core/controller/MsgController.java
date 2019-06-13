package com.qfedu.common.msg.core.controller;

import com.qfedu.common.msg.core.entity.Message;
import com.qfedu.common.msg.core.service.MsgService;
import com.qfedu.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：mmzs.
 * @ Date       ：Created in 20:54 2019/6/13
 */
@RestController
@Api(value = "发送信息/新闻" ,tags = "发送信息验证码/邮箱激活码")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @ApiOperation(value = "发送激活码",notes = "发送信息")
    @PostMapping("/Msg/sendMsg.do")
    public R  sendMessage(@RequestBody Message message , HttpServletRequest httpServletRequest){

        return msgService.sendMsg(message, httpServletRequest.getRemoteAddr());
    }
}
