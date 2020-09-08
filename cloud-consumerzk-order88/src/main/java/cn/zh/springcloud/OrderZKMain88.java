package cn.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PSVM
 * @date 2020/9/8 - 11:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain88.class, args);
    }
}
