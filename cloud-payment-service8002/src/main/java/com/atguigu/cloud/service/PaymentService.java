package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author dpy
 * @create 2022-07-15 19:25
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
