package cn.zh.springcloud.controller;

import cn.zh.springcloud.entities.CommonResult;
import cn.zh.springcloud.entities.Payment;
import cn.zh.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PSVM
 * @date 2020/9/9 - 10:38
 */
@RestController
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/feign/{id}")
    public CommonResult paymentFeign(@PathVariable("id") Long id) {
        CommonResult<Payment> paymentCommonResult = paymentFeignService.get(id);
        return paymentCommonResult;
    }

}
