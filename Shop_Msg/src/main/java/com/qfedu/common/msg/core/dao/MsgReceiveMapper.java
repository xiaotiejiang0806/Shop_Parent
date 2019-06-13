package com.qfedu.common.msg.core.dao;

import com.qfedu.common.msg.core.entity.MsgReceive;

import java.util.List;

public interface MsgReceiveMapper {

    List<MsgReceive> findAll();

    int insert(MsgReceive record);


}