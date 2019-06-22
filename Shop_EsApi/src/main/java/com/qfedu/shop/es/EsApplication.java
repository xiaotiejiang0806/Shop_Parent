package com.qfedu.shop.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:07 2019/6/21
 */
@SpringBootApplication
@EnableSwagger2
public class EsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class,args);
    }
}
