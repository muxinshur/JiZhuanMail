package com.mail.infrastructure.impl;

import com.mail.domain.order.domain.aggregate.entity.Order;
import com.mail.domain.order.domain.aggregate.repository.orderRepository;
import org.springframework.stereotype.Service;

@Service
public class orderRepositoryImpl implements orderRepository {
    @Override
    public void saveOrUpdate(Order order) {

    }

    @Override
    public Order find(long orderId) {
        return null;
    }
}
