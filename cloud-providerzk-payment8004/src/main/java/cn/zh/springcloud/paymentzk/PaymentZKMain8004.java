package cn.zh.springcloud.paymentzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PSVM
 * @date 2020/9/8 - 10:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZKMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZKMain8004.class, args);
    }
}
