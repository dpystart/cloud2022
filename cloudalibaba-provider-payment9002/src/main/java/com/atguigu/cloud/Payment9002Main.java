package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dpy
 * @create 2022-07-22 21:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9002Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment9002Main.class,args);
    }

}
