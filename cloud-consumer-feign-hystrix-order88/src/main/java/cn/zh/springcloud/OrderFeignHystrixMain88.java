package cn.zh.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author PSVM
 * @date 2020/9/9 - 14:09
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix /*启用hystrix 断路器*/
public class OrderFeignHystrixMain88 {
    public static void main(String[] args) {
            SpringApplication.run(OrderFeignHystrixMain88.class, args);
    }
}
