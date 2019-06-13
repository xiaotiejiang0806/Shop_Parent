package com.qfedu.common.msg.core.controller;

import com.qfedu.common.msg.core.entity.Message;
import com.qfedu.common.msg.core.service.MsgService;
import com.qfedu.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：Demos
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

    @ApiOperation(value = "核对验证码",notes = "核对验证码")
    @GetMapping("/Msg/checkCode.do")
    public R checkMessage(String phone,int code){
        return msgService.checkMsg(phone,code);
    }


    @ApiOperation(value = "分页查询",notes = "分页查询短信")
    @GetMapping("/Msg/getMessages.do")
    public R findMessageByPage(int page){
        return msgService.findByPage(page);
    }
}
