package com.qfedu.shop.job.config;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 19:49 2019/6/18
 * @ Description：${description}
 */
public class TaskConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(creatExecutor());
    }

    private Executor creatExecutor(){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        return threadPoolExecutor;
    }
}
