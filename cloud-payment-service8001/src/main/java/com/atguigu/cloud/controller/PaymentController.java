package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.font.FontRunIterator;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;


/**
 * @author dpy
 * @create 2022-07-15 19:34
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入操作返回结果哈哈哈" + result);

        if (result > 0 ){
            return new CommonResult(200,"插入数据库成功8001",result);
        }else{
            return new CommonResult(444,"插入数据库失败8001",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果为哈哈 " + payment);

        if (payment != null){
            return new CommonResult(200,"查询成功8001",payment);
        }else{
            return new CommonResult(200,"查询失败8001",null);
        }
    }



    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            System.out.println(element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element: instances){
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }

        return this.discoveryClient;
    }

}
