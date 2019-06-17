package com.qfedu.common.model;

import lombok.Data;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:46 2019/6/14
 * @ Description：令牌的模型层
 */
@Data
public class LoginToken {

    private  String id;
    private String phone;
    private int uid;
}
