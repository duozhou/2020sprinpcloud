package cn.zh.springcloud.controller;

import cn.zh.springcloud.entities.CommonResult;
import cn.zh.springcloud.entities.Payment;
import cn.zh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * @author PSVM
 * @date 2020/9/7 - 14:01
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    String server_port;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        return new CommonResult<Payment>(200, "查询成功；端口：8001", payment);
    }

    @PostMapping("/payment/insert")
    public CommonResult<Payment> get(@RequestBody Payment payment) {
        Long aLong = paymentService.insert(payment);
        return new CommonResult<Payment>(200, MessageFormat.format("插入成功，返回id：{0}", aLong));
    }

    @GetMapping("/payment/lb")
    public String lb() {
        return server_port;
    }

}
