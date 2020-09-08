package cn.zh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author PSVM
 * @date 2020/9/8 - 14:14
 */
@RestController
public class OrderConsulController {

    private static final String PAYMENT_CONSUL_URL = "http://cloud-providerconsul-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/order/payment/consul")
    public String paymentConsul() {
        return restTemplate.getForObject(PAYMENT_CONSUL_URL + "/payment/consul", String.class);
    }
}
