package com.mail.domain.aggregate.order.repository;

import com.mail.domain.aggregate.order.entity.Order;

public interface OrderRepository {

    public void saveOrUpdate(Order order);

    public Order find(long orderId);

}
