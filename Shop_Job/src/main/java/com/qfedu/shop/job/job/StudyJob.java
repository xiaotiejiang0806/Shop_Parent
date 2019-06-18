package com.qfedu.shop.job.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 17:47 2019/6/18
 * @ Description：${description}
 */
public class StudyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("好好学习");
    }
}
