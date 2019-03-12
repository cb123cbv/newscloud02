package com.jk.controller;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TriggerManager {
    /**
     * 添加定时任务
     *
     * @param JobName        工作名称，可任意定义，不重复
     * @param JobGroupName   工作组名称，建议统一规划，可重复
     * @param time           启动的时间
     * @param jobClass       要执行的工作类
     * @param parameter      传递的参数
     * @param servletContent application对象，取得spring bean对象的关键
     */
    @SuppressWarnings({"deprecation"})
    @ResponseBody
    @RequestMapping("addJob")
    public static void addJob(String JobName, String JobGroupName, String time,
                              Class<? extends Job> jobClass, String parameter, ApplicationContext servletContent) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = new JobDetailImpl(JobName, JobGroupName, jobClass);// 任务名，任务组，任务执行类
            jobDetail.getJobDataMap().put("jobName", parameter);
            jobDetail.getJobDataMap().put("servletContent", servletContent);
            CronTrigger trigger = new CronTriggerImpl(JobName, JobGroupName,
                    time);// 触发器名,触发器组,触发时间
            scheduler.scheduleJob(jobDetail, trigger);// 将任务信息添加到sheduler中
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void delJob(String JobName, String JobGroupName) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = new TriggerKey(JobName, JobGroupName);
            JobKey jobKey = new JobKey(JobName, JobGroupName);
            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 删除触发器
            scheduler.deleteJob(jobKey);// 删除任务
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
