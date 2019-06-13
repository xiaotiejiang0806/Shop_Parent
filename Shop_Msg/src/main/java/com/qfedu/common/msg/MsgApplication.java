package com.qfedu.common.msg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.qfedu.common.msg.core.dao")
public class MsgApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsgApplication.class,args);
    }

}
