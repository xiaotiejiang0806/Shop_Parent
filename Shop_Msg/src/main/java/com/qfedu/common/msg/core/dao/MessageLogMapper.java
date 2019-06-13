package com.qfedu.common.msg.core.dao;

import com.qfedu.common.msg.core.entity.MessageLog;

import java.util.List;

public interface MessageLogMapper {
    int insert(MessageLog record);

    List<MessageLog> findAll();

}