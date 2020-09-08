package cn.zh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author PSVM
 * @date 2020/9/8 - 15:11
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
