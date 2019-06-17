package com.qfedu.shop.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:37 2019/6/15
 */

@Data
public class UserSign {

    private Integer id;
    private Integer uid;
    private Integer score;
    private Integer extrascore;
    private Date createtime;
    private Integer days;
}
