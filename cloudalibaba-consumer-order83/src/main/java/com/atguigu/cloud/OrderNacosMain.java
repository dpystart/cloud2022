package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dpy
 * @create 2022-07-22 22:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain.class,args);
    }
}
