package com.qfedu.shop.server.user.service;

import com.qfedu.common.execption.UserException;
import com.qfedu.common.vo.R;
import com.qfedu.shop.entity.User;

public interface UserService {

    R addUser(User user) throws UserException;

    R all();

    R checkPhone(String phone);
}
