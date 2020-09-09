package cn.zh.springcloud.service.hystrixfallback;

import cn.zh.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author PSVM
 * @date 2020/9/9 - 17:28
 */
@Component
public class PaymentHystrixFallBackService implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "PaymentHystrixFallBackService....paymentOk...fallback...";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentHystrixFallBackService....paymentTimeout...fallback...";
    }
}
