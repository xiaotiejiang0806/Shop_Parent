package com.qfedu.shop.server.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.jwt.JwtUtil;
import com.qfedu.common.model.LoginToken;
import com.qfedu.common.util.JedisUtil;
import com.qfedu.common.util.TimeUtil;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.Points;
import com.qfedu.shop.entity.UserSign;
import com.qfedu.shop.server.user.dao.PointsMapper;
import com.qfedu.shop.server.user.dao.UserPointsMapper;
import com.qfedu.shop.server.user.dao.UserSignDao;
import com.qfedu.shop.server.user.service.UserSingnService;
import com.qfedu.shop.server.user.util.RandomUtil;
import com.qfedu.shop.server.user.util.UserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:25 2019/6/15
 * @ Description：${description}
 */
@Service
@Transactional
public class UserSinginServiceImpl implements UserSingnService {

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private UserSignDao userSignDao;
    @Autowired
    private PointsMapper pointsMapper;
    @Autowired
    private UserPointsMapper userPointsMapper;
    @Override
    public R saveSingn(String token) {
        LoginToken loginToken = JSON.parseObject(JwtUtil.parseJWT(token), LoginToken.class);
        boolean issign = true;
        boolean isfirst = false;
        if (jedisUtil.exists(ProjectConfig.SINGKEY)) {
            if (jedisUtil.sismember(ProjectConfig.SINGKEY, loginToken.getPhone())) {
                issign = false;
                //  今天已经签过到
                return R.setERROR("亲，今天已经签到过了！");
            }
        }else {
            isfirst = true;
        }
        if (issign){
        //  今天没有签到过，获取该用户是否已经存在签到记录，若没有则说明该用户是第一次签到
        UserSign userSign = userSignDao.selectByUidLast(loginToken.getUid());
        int score = RandomUtil.creatScore(3, 5);
        int extra = 0;
        int lxday = 1;
        String info = "";
        if (userSign == null) {
            //  说明是第一次签到
            extra = ProjectConfig.INTITLOGINSCORE;
            info = "第一次签到，赠送" + extra + "积分";
        } else {
            //  查询该用户是否是连续签到
            Date createtime = userSign.getCreatetime();
            int days = TimeUtil.getDistanceDays(createtime);
            lxday = userSign.getDays() + 1;
            if (days == 1) {
                //  连续签到
                if (lxday % 365 == 0) {
                    extra = 365;
                    info = "恭喜您连续签到" + lxday + "天，赠送您" + extra + "分数";
                } else if (lxday % 30 == 0) {
                    extra = 50;
                    info = "恭喜您连续签到" + lxday + "天，赠送您" + extra + "分数";
                } else if (lxday % 5 == 0) {
                    extra = 10;
                    info = "恭喜您连续签到" + lxday + "天，赠送您" + extra + "分数";
                } else if (lxday % 3 == 0) {
                    extra = score;
                    info = "恭喜您连续签到" + lxday + "天,赠送您" + extra + "分数";
                } else {
                    info = "签到成功，赠送您" + score + "积分";
                }
            } else {
                //  断签
                info = "您上一次是在" + TimeUtil.getFormatDate(userSign.getCreatetime()) + "签到,欢迎您又来签到了~";
            }
        }
            UserSign sign = new UserSign();
            sign.setUid(loginToken.getUid());
            sign.setDays(lxday);
            sign.setScore(score);
            sign.setExtrascore(extra);
            userSignDao.insert(sign);

            Points points = new Points();
            points.setScore(score + extra);
            points.setFlag((short) 1);
            points.setStartdate(new Date());
            points.setEnddate(TimeUtil.getDays(ProjectConfig.NEWEXPIRE));
            points.setUid(loginToken.getUid());
            points.setInfo(info);
            pointsMapper.insert(points);
            userPointsMapper.updatePoints(loginToken.getUid(),score +extra);
            //保存至数据库
            jedisUtil.sadd(ProjectConfig.SINGKEY,loginToken.getPhone());
            //  如果是第一个来签到的
            if (isfirst){
                jedisUtil.expire(ProjectConfig.SINGKEY,TimeUtil.getLastSecond());
            }
            return R.setOK("签到成功",userSign);
     }
        return null;
    }

    @Override
    public R querryByDays(String token, int days) {
        int id = UserTokenUtil.parseTokenId(jedisUtil.get(ProjectConfig.TOKENJWT + token));
        return R.setOK("ok", userSignDao.selectVByDateAndUid(days,id));
    }

    @Override
    public R querryByUid(String token) {
        int id = UserTokenUtil.parseTokenId(jedisUtil.get(ProjectConfig.TOKENJWT + token));
        return R.setOK("ok",userSignDao.selectByUid(id));
    }

    @Override
    public R querrySingle(String token) {
        int id = UserTokenUtil.parseTokenId(jedisUtil.get(ProjectConfig.TOKENJWT + token));
        return R.setOK("ok",userSignDao.selectByUidLast(id));
    }

}