package com.qfedu.shop.es.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:32 2019/6/21
 * @ Description：${description}
 */
@Document(indexName = "erroLog",type = "RedisLog")
@Data
public class EsLog {
    @Id
    private Integer id;
    private String content;
}
