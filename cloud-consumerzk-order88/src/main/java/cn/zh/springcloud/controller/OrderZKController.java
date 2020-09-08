package cn.zh.springcloud.controller;

import cn.zh.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author PSVM
 * @date 2020/9/8 - 11:29
 */
@RestController
public class OrderZKController {

    private static final String PAYMENT_ZK_URL = "http://cloud-providerzk-payment";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/order/payment/zk")
    public CommonResult paymentZK() {
        return restTemplate.getForObject(PAYMENT_ZK_URL + "/payment/zk", CommonResult.class);
    }
}
