package cn.zh.springcloud.controller;

import cn.zh.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * @author PSVM
 * @date 2020/9/9 - 14:13
 */
@RestController
/*@DefaultProperties(defaultFallback = "globalFallbackMethod")*/
public class OrderHystrixController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        //int n = 10 / 0;
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    /*@HystrixCommand*/
    public String paymentTimeout(@PathVariable("id") Integer id) {
        int n = 10 / 0;
        return paymentHystrixService.paymentTimeout(id);
    }

    public String paymentTimeOutFallbackMethod(Integer id) {
        return "客户端（调用端）paymentTimeout 超时或者异常...";
    }

    public String globalFallbackMethod() {
        return "全局超时或者异常...";
    }

}
