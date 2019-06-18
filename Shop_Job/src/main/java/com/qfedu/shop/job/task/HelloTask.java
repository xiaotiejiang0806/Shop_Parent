package com.qfedu.shop.job.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:00 2019/6/18
 * @ Description：${description}
 */
@Component
public class HelloTask {

    @Scheduled(cron = "0/2 30 20 * * ?")
    public void task1(){
        System.out.println("这是一个好的开始~");
    }
}
