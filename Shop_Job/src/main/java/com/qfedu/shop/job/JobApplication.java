package com.qfedu.shop.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 17:29 2019/6/18
 */
@SpringBootApplication (exclude = {QuartzAutoConfiguration.class})
@EnableScheduling
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class,args);
    }
}
