package com.cjw.springcloud.service;

import com.cjw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById( Long id);
}
