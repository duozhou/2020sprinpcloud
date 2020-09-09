package cn.zh.springcloud.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author PSVM
 * @date 2020/9/9 - 13:54
 */
@Component
@Slf4j
public class PaymentService {

    public String paymentOk(Integer id) {
        return "线程： " + Thread.currentThread().getName() + " paymentOk id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentTimeout(Integer id) {
        log.info("provider...PaymentService...paymentTimeout...001...");
        //int n = 10 / 0;
        long second = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("provider...PaymentService...paymentTimeout...002...");
        return "线程： " + Thread.currentThread().getName() + " paymentTimeout id：" + id + " sleep：" + second;
    }

    public String paymentTimeOutFallbackMethod(Integer id) {
        return "线程： " + Thread.currentThread().getName() + " paymentTimeOutFallbackMethod id：" + id;
    }
}
