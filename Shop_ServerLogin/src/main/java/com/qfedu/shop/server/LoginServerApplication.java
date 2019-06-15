package com.qfedu.shop.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:25 2019/6/14
 * @ Description：${description}
 */
@SpringBootApplication
@MapperScan("com.qfedu.shop.server.dao")
@EnableEurekaClient
public class LoginServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginServerApplication.class,args);
    }
}
