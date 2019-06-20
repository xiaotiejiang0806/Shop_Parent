package com.qfedu.shop.api.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:36 2019/6/14
 */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class,args);
    }
}
