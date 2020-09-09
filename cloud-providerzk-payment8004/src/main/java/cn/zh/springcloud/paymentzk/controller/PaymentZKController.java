package cn.zh.springcloud.paymentzk.controller;

import cn.zh.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author PSVM
 * @date 2020/9/8 - 10:55
 */
@RestController
public class PaymentZKController {

    @GetMapping("/payment/zk")
    public CommonResult paymentZk() {
        String s = MessageFormat.format("PaymentZKController...paymentZk...{0}", UUID.randomUUID().toString());
        return new CommonResult<String>(200, "success", s);
    }

}
