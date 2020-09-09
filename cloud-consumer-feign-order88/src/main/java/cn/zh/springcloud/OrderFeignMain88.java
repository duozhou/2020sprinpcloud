package cn.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author PSVM
 * @date 2020/9/9 - 10:34
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain88.class, args);
    }
}
