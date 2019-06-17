package com.qfedu.shop.resouce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:42 2019/6/16
 * @ Description：${description}
 */
@SpringBootApplication
@EnableSwagger2
public class ResouceApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ResouceApplication.class,args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ResouceApplication.class);
    }
}
