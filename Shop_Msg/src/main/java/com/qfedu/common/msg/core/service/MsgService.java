package com.qfedu.common.msg.core.service;

import com.qfedu.common.msg.core.entity.Message;
import com.qfedu.common.vo.R;

public interface MsgService {
    /**
     *  发送信息
     * @param message
     * @return
     */
    public R sendMsg(Message message,String ip);
}
