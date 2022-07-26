package com.atguigu.cloud;

import com.atguigu.myrule.MyselfRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author dpy
 * @create 2022-07-15 22:36
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="cloud-payment-service",configuration = MyselfRule.class)
public class MainApp80 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp80.class,args);
    }
}
