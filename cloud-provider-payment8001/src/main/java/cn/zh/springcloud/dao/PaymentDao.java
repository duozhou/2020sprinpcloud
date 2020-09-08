package cn.zh.springcloud.dao;

import cn.zh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author PSVM
 * @date 2020/9/7 - 11:50
 */
@Component
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

/*    public Payment getById(Long id);

    public Long insert(Payment payment);*/
}
