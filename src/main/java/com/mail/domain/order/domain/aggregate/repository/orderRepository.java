package com.mail.domain.order.domain.aggregate.repository;

import com.mail.domain.order.domain.aggregate.entity.Order;

public interface orderRepository {

    public void saveOrUpdate(Order order);

    public Order find(long orderId);

}
