package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


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

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入操作返回结果哈哈哈" + result);

        if (result > 0 ){
            return new CommonResult(200,"插入数据库成功8002",result);
        }else{
            return new CommonResult(444,"插入数据库失败8002",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果为哈哈 " + payment);

        if (payment != null){
            return new CommonResult(200,"查询成功8002",payment);
        }else{
            return new CommonResult(200,"查询失败8002",null);
        }
    }


}
