package com.cjw.springcloud.controller;

import com.cjw.springcloud.entities.CommonResult;
import com.cjw.springcloud.entities.Payment;
import com.cjw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据 id" + payment.getId());
        log.info("插入结果为"+ result);
        if(result > 0) {
            return  new CommonResult<Integer>(200,"插入成功",result);
        }else {
            return new CommonResult(500,"插入失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment  = paymentService.getPaymentById(id);
        log.info("查询结果为"+ payment);
        if( payment != null) {
            return  new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(500,"没有对应的记录");
        }
    }
}
