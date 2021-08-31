package com.cjw.springcloud.controller;

import com.cjw.springcloud.entities.CommonResult;
import com.cjw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.cert.CertificateExpiredException;

@RestController
@Slf4j
public class OrderController {

    private static final String URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL+"/payment/"+id, CommonResult.class,id );
    }

    @GetMapping
    public  CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(URL+"/payment", payment, CommonResult.class);
    }


}
