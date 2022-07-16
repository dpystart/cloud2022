package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author dpy
 * @create 2022-07-15 22:42
 */
@RestController
public class OrderController {
    public static final String paymentServ_URL="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(paymentServ_URL + "/payment/create",payment,CommonResult.class);

    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(paymentServ_URL + "/payment/get/" + id,CommonResult.class);

    }

}
