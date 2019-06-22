package com.qfedu.shop.es.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:07 2019/6/21
 * @ Description：${description}
 */
@Data
@Document(indexName = "ljb:allgoods",type = "esgoods")
public class EsGoods {
    private Integer id;
    private String name;
    private String type;
}
