package com.qfedu.common.msg.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.model.ActiveCode;
import com.qfedu.common.model.EmailMsg;
import com.qfedu.common.msg.core.dao.MessageLogMapper;
import com.qfedu.common.msg.core.dao.MessageMapper;
import com.qfedu.common.msg.core.dao.MsgReceiveMapper;
import com.qfedu.common.msg.core.entity.Message;
import com.qfedu.common.msg.core.entity.MessageLog;
import com.qfedu.common.msg.core.entity.MsgReceive;
import com.qfedu.common.msg.core.service.MsgService;
import com.qfedu.common.util.*;
import com.qfedu.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageLogMapper messageLogMapper;
    @Autowired
    MsgReceiveMapper msgReceiveMapper;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    @Transactional
    public R sendMsg(Message message,String ip) {
        int count = 0;
        if (message.getType()<4){
            String c = jedisUtil.get(ProjectConfig.SMSPREDAY+message.getReceive());
            if (c != null && c.matches("[0-9]{1,2}")){
                count = Integer.parseInt(c);
                if (count >= 20){
                    return R.setERROR("亲，您已经超过上限了哦");
                }
            }
            if (jedisUtil.exists(ProjectConfig.SMSPRELIMIT+message.getReceive())){
                return R.setERROR("亲，请不要频繁操作哦~");
            }
        }
        int code = CodeUtil.createNum(6);
        int flag = 3;
        String info = "";
        boolean isflag = false;
        try {
            switch (message.getType()){
                case 1://发送短信验证码
                    if (jedisUtil.exists(ProjectConfig.SMSCODE+ message.getReceive())){
                        code = Integer.parseInt(jedisUtil.get(ProjectConfig.SMSCODE+message.getReceive()));
                    }else {
                        code = CodeUtil.createNum(6);
                        isflag = true;
                    }
                    info = "发送短信验证码" +code;
                    SendMsgUtil.mobileQuery(message.getReceive(), code);
                    flag = 1;
                    //将信息放在redis中，一分钟的有效期
                    jedisUtil.setex(ProjectConfig.SMSPRELIMIT+message.getReceive(),60,"短信发送限制");
                    jedisUtil.setex(ProjectConfig.SMSPREDAY+message.getReceive(), TimeUtil.getLastSecond(),(count+1)+"");
                    if (isflag){
                        jedisUtil.setex(ProjectConfig.SMSCODE+message.getReceive(),180,code+"");
                    }
                    break;
                case 4://发送邮箱激活码
                    info = "发送邮箱激活码: " +code;
                    EmailMsg emailMsg = new EmailMsg();
                    emailMsg.setCompany(ProjectConfig.projects.get(message.getPcode()));
                    ActiveCode activeCode = new ActiveCode();
                    activeCode.setEmail(message.getReceive());
                    activeCode.setCode(code);
                    String mw = EncryptionUtil.AESEnc(ProjectConfig.AESKEYACTIVECODE, JSON.toJSONString(activeCode));
                    String u=ProjectConfig.ACTIVEURL+"?data="+mw+"&email="+EncryptionUtil.AESEnc(ProjectConfig.AESKEYACTIVECODE,"1147016722@qq.com");
                    emailMsg.setContent("欢迎注册："+emailMsg.getCompany()+",请激活使用，<a href=''></a>");
                    EmailUtil.sendEmail(emailMsg);
                    flag=1;
                    break;
            }
        }catch (Exception e){
            flag = 2;
        }finally {
            //向信息数据库中插入数据
            messageMapper.insert(message);
            MessageLog messageLog = new MessageLog();
            messageLog.setInfo(info);
            messageLog.setIp(ip);
            messageLog.setMid(message.getId());
            messageLogMapper.insert(messageLog);

            MsgReceive msgReceive = new MsgReceive();
            msgReceive.setNo(message.getReceive());
            msgReceive.setFlag(message.getType()<4?1:2);
            msgReceiveMapper.insert(msgReceive);
        }
        return null;
    }

    @Override
    public R checkMsg(String phone, int code) {
        String key = ProjectConfig.SMSCODE + phone;
        if (jedisUtil.exists(key)){
            String s = jedisUtil.get(key);
            if (s != null){
                int i = Integer.parseInt(s);
                if (i == code){
                    return R.setOK("验证通过",null);
                }else {
                    return R.setERROR("验证码错误");
                }
            }
        }
        return R.setERROR("验证码已过期，请重新获取");
    }

    @Override
    public R findByPage(int page) {
        PageHelper.startPage(page,5);
        List<Message> all = messageMapper.findAll();
        Map<String,Object> map = new HashMap<>();
        map.put("data",all);
        map.put("count",((Page)all).getTotal());
        return R.setOK("ok",map);
    }

}
