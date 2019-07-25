package com.mdq.simpletest.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.mdq.simpletest.demo.mapper")
//@EnableScheduling
@EnableEurekaServer
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//            SpringApplication application = new SpringApplication(DemoApplication.class);
//            //配置事件监听器
//            application.addListeners(new MyApplicationListener());
//            ConfigurableApplicationContext context =application.run(args);
//            //发布事件
//            context.publishEvent(new MyApplicationEvent(new Object()));
//            context.close();
        SpringApplication.run(DemoApplication.class, args);
    }
}
