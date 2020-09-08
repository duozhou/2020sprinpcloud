package cn.zh.springcloud.service.impl;

import cn.zh.springcloud.dao.PaymentDao;
import cn.zh.springcloud.entities.Payment;
import cn.zh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PSVM
 * @date 2020/9/7 - 13:54
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public Payment getById(Long id) {
        Payment payment = paymentDao.selectByPrimaryKey(id);
        return payment;
    }

    @Override
    public Long insert(Payment payment) {
        long i = paymentDao.insert(payment);
        return i;
    }
}
