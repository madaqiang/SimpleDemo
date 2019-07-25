package com.mdq.simpletest.demo.utils;

import com.mdq.simpletest.demo.model.User;
import com.mdq.simpletest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
//public class TestUtil implements ApplicationRunner {
//public class TestUtil implements CommandLineRunner {
public class TestUtil {

    @Autowired
   private  UserService userService;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Value("${cronTime}")
    private String cronTime;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        System.out.println("自动执行成功ApplicationRunner=======》"+ args.toString());
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("自动执行成功CommandLineRunner=======》"+ args.toString());
//    }
    //@Autowired
    public void run() throws Exception {
//        User user = new User("today",13);
//       int result =  userService.insertUser(user);
   //     System.out.println("自动执行成功Autowired=======》");
        System.out.println(cronTime);
        ScheduleUtil scheduleUtil= new ScheduleUtil();
        System.out.println( scheduleUtil.scheduleDemo(threadPoolTaskScheduler,cronTime));
    }
}
