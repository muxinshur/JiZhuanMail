package com.mail.infrastructure.repository;

import com.mail.domain.aggregate.order.entity.Order;
import com.mail.domain.aggregate.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void saveOrUpdate(Order order) {}

    @Override
    public Order find(long orderId) {
        return null;
    }
}
