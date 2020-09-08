package cn.zh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current == Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println(next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
