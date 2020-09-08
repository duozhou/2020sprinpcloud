package cn.zh.springcloud.service;

import cn.zh.springcloud.entities.Payment;

/**
 * @author PSVM
 * @date 2020/9/7 - 13:53
 */
public interface PaymentService {

    public Payment getById(Long id);

    public Long insert(Payment payment);
}
