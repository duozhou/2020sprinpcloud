package cn.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PSVM
 * @date 2020/9/8 - 14:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain88 {
    public static void main(String[] args) {
            SpringApplication.run(OrderConsulMain88.class, args);
    }
}
