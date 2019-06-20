package com.qfedu.shop.server.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 9:45 2019/6/19
 * @ Description：${description}
 */
@SpringBootApplication
@MapperScan("com.qfedu.shop.server.goods.dao")
@EnableEurekaClient
@EnableTransactionManagement
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
