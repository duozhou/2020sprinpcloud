package cn.zh.springcloud.controller;

import cn.zh.springcloud.entities.CommonResult;
import cn.zh.springcloud.entities.Payment;
import cn.zh.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author PSVM
 * @date 2020/9/7 - 15:26
 */
@RestController
public class OrderController {

    private final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancer loadBalancer;


    @GetMapping("/order/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/order/insert")
    public CommonResult insert(Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment,
                CommonResult.class);
        return commonResult;
    }


    @GetMapping("/consumer/order/lb")
    public String lb() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalancer.instance(serviceInstances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri);
        String s = restTemplate.getForObject(uri + "/payment/lb", String.class);
        return s;
    }


}
