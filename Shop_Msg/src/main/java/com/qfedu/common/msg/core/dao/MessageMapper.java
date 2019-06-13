package com.qfedu.common.msg.core.dao;

import com.qfedu.common.msg.core.entity.Message;

import java.util.List;

public interface MessageMapper {

    int insert(Message record);

    List<Message> findAll();


}