package com.mdq.simpletest.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Component
public class ScheduleUtil {

    private ScheduledFuture<?> future1;
    //@Scheduled(cron = "")
    public void timer(){
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public String scheduleDemo(ThreadPoolTaskScheduler threadPoolTaskScheduler,String cronTime){
        System.out.println(threadPoolTaskScheduler);
        future1 = threadPoolTaskScheduler.schedule(this::timer, new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(cronTime).nextExecutionTime(triggerContext);
            }
        });
        return "****";
    }

    /***
     * 取消
     * @return
     */
    public String  stopCron1() {
        if (future1 != null) {
            future1.cancel(true);
        }
        System.out.println("DynamicTask.stopCron1()");
        return "888";
    }
}
