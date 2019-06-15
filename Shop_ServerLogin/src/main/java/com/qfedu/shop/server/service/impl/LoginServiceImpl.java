package com.qfedu.shop.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.jwt.JwtUtil;
import com.qfedu.common.util.EncryptionUtil;
import com.qfedu.common.util.IdGenerator;
import com.qfedu.common.util.JedisUtil;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;
import com.qfedu.shop.server.dao.LoginDao;
import com.qfedu.shop.server.dao.UserDao;
import com.qfedu.shop.server.model.LoginToken;
import com.qfedu.shop.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:32 2019/6/14
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired
    private IdGenerator idGenerator;


    @Override
    public R login(String phone, String pass) {

        R r;

        if (jedisUtil.exists(ProjectConfig.USERSD+phone)){
            r = R.setERROR("该账号已被封禁，请于"+(jedisUtil.ttl(ProjectConfig.USERSD+phone))/60 + "分钟后再来登录");
        }else {
            User user = userDao.findUser(phone);

            if (user != null){
                String s = EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI, pass);
                if (Objects.equals(user.getPassword(),s)){
                    LoginToken loginToken = new LoginToken();
                    loginToken.setId(idGenerator.nextId() + "");
                    loginToken.setPhone(phone);
                    loginToken.setUid(user.getId());
                    //  生成token
                    String token = JwtUtil.createJWT(loginToken.getId(), JSON.toJSONString(loginToken));
                    //  将token放在redis中
                    jedisUtil.setex(ProjectConfig.TOKENPHONE + phone,1800,token);
                    jedisUtil.setex(ProjectConfig.TOKENJWT + token,1800,phone);
                    loginDao.saveLog(user.getId(),"登录成功，生成令牌");
                    r = R.setOK("登录成功",token);
                }else {
                    r = R.setERROR("密码错误");
                    loginDao.saveLog(user.getId(),"登录失败，密码错误");
                }
            }else {
                r = R.setERROR("亲，还未注册哦~");
            }
            if (r.getCode() != 1){
                String key = ProjectConfig.USERLOGINCOUNT + phone;
                jedisUtil.setex(key + "_" + System.currentTimeMillis(),600,"登录失败" );
                Set<String> set = jedisUtil.keys(key + "*");
                if (set.size() == 3){
                    loginDao.saveLog(user.getId(),"该账号被封禁一个小时");
                    jedisUtil.setex(ProjectConfig.USERSD+phone,3600,"账号封禁1个小时");
                    r = R.setERROR("该账号由于多次操作失败，呗封禁一个小时");
                }
            }
        }
        return r;
    }

    @Override
    public R checkLogin(String token) {

        if (JwtUtil.checkJWT(token)){
            LoginToken loginToken = JSON.parseObject(JwtUtil.parseJWT(token), LoginToken.class);
            if (Objects.equals(jedisUtil.get(ProjectConfig.TOKENPHONE + loginToken.getPhone()),token)){
                return R.setOK("验证通过",null);
            }else {
                return R.setERROR("已在其他地点登录");
            }
        }else {
            return R.setERROR("令牌不合法");
        }
    }

    @Override
    public R exitLogin(String token) {

        if (JwtUtil.checkJWT(token)){
            jedisUtil.del(ProjectConfig.TOKENJWT + token);
            LoginToken loginToken = JSON.parseObject(JwtUtil.parseJWT(token), LoginToken.class);
            jedisUtil.del(ProjectConfig.TOKENPHONE+loginToken.getPhone());
            return R.setOK("安全退出",null);
        }else {
            return R.setERROR("令牌不合法");
        }

    }
}
