package com.qfedu.shop.server.goods.dto;

import lombok.Data;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 15:50 2019/6/19
 * @ Description：${description}
 */
@Data
public class GoodsListDto {
    private Integer id;
    private String name;
    private Integer gtid;
    private String brand;
    private String discount;
    private Integer flag;
    private String picurl;
    private int minprice;
    private int paycount;
}
