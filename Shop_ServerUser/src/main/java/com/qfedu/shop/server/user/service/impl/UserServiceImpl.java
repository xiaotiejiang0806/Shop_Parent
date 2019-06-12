package com.qfedu.shop.server.user.service.impl;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.execption.UserException;
import com.qfedu.common.util.TimeUtil;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.Cart;
import com.qfedu.shop.entity.Points;
import com.qfedu.shop.entity.User;
import com.qfedu.shop.entity.UserPoints;
import com.qfedu.shop.server.user.dao.*;
import com.qfedu.shop.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


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



    @Override
    @Transactional(rollbackFor = {UserException.class})
    public R addUser(User user) throws UserException {


        try {
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
}
