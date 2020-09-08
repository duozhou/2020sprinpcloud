package cn.zh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author PSVM
 * @date 2020/9/8 - 13:52
 */
@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "Spring Cloud paymentConsul...serverPort：" + serverPort + "..." + UUID.randomUUID();
    }

}
