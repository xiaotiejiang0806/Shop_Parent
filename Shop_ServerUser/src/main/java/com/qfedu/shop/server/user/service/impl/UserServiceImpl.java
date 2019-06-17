package com.qfedu.shop.server.user.service.impl;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.execption.UserException;
import com.qfedu.common.util.EncryptionUtil;
import com.qfedu.common.util.JedisUtil;
import com.qfedu.common.util.TimeUtil;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.*;
import com.qfedu.shop.server.user.dao.*;
import com.qfedu.shop.server.user.service.UserService;
import com.qfedu.shop.server.user.util.UserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private PointsMapper pointsMapper;

    @Autowired
    private UserPointsMapper userPointsMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired
    private UserLogMapper userLogMapper;


    @Override
    @Transactional(rollbackFor = {UserException.class})
    public R addUser(User user) throws UserException {

        try {
            user.setPassword(EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI,user.getPassword()));
            //  新增用户
            userMapper.insert(user);
            Integer id = user.getId();
            //  初始化用户详情
            userDetailMapper.insertinituser(id);
            //  初始化积分详情
            Points points = new Points();
            points.setUid(user.getId());
            points.setStartdate(new Date());
            points.setInfo("新用户注册，奖励"+ProjectConfig.INITSCORE+"积分");
            points.setScore(ProjectConfig.INITSCORE);
            points.setEnddate(TimeUtil.getDays(ProjectConfig.ENDDATE));
            points.setFlag((short) 1);
            pointsMapper.insert(points);

            //  初始化积分
            UserPoints userPoints = new UserPoints();
            userPoints.setUid(user.getId());
            userPoints.setCurrscore(ProjectConfig.INITSCORE);
            userPoints.setTotalscore(ProjectConfig.INITSCORE);
            userPointsMapper.insert(userPoints);

            //  初始化购物车

            Cart cart = new Cart();
            cart.setUid(user.getId());
            cart.setCurrcount(0);
            cart.setMaxcount(ProjectConfig.INITCOUNT);
            cartMapper.insert(cart);
        } catch (Exception e){
            throw new UserException("用户注册错误");
        }
        return R.setOK();
    }

    @Override
    public R all() {

        return R.setOK("ok",userMapper.all());
    }

    @Override
    public R checkPhone(String phone) {
        User user = userMapper.findUserByPhone(phone);
        if (user == null) {
            return R.setOK("该手机号可用",null);
        }else {
            return R.setERROR("该号码已使用");
        }
    }

    @Override
    public R updateInfo(UserDetail userDetail,String token) {
        int uid = UserTokenUtil.parseTokenId(jedisUtil.get(ProjectConfig.TOKENJWT + token));
        userDetail.setUid(uid);
        userDetailMapper.updateByPrimaryKey(userDetail);
        return R.setOK("更新成功",null);
    }

    @Override
    @Transactional
    public R updatePass(String token, String pass) {

        User user = UserTokenUtil.parseToken(jedisUtil.get(ProjectConfig.TOKENJWT + token));
        String mw = EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI, pass);

        if (Objects.equals(user.getPassword(),mw)){
            return R.setERROR("和原密码一致，请重新填写密码");
        }else {
            userMapper.updatePass(user.getId(),mw);
            UserLog userLog = new UserLog();
            userLog.setFlag(3);
            userLog.setContent("修改密码成功");
            userLog.setUid(user.getId());
            userLog.setCreattime(new Date());
            userLogMapper.insert(userLog);
            jedisUtil.del(ProjectConfig.TOKENPHONE + user.getPhone());
            return R.setOK("密码修改成功",null);
        }
    }
}
