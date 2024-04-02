package com.mail.domain.order.service.impl;

import com.mail.common.utils.SnowFlakeUtils;
import com.mail.domain.order.domain.aggregate.entity.Order;
import com.mail.domain.order.domain.aggregate.entity.valueObject.Address;
import com.mail.domain.order.domain.aggregate.entity.valueObject.OrderItem;
import com.mail.domain.order.domain.aggregate.repository.orderRepository;
import com.mail.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private SnowFlakeUtils snowFlakeUtils;

    @Autowired
    private orderRepository orderRepository;

    @Override
    public void createOrder(String buyerId, String sellerId, Set<OrderItem> orderItemList, Address address) {
        Order order = new Order(snowFlakeUtils.nextId(), buyerId, sellerId, orderItemList, address);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateDiscountPrice(long orderId, BigDecimal discountPrice) {
        Order order = orderRepository.find(orderId);
        order.setDiscountPrice(discountPrice);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateExpressId(long orderId, String expressId) {
        Order order = orderRepository.find(orderId);
        order.setExpressId(expressId);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateExpressPrice(long orderId, BigDecimal expressPrice) {
        Order order = orderRepository.find(orderId);
        order.setExpressPrice(expressPrice);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateAddress(long orderId, Address address) {
        Order order = orderRepository.find(orderId);
        order.setAddress(address);
        orderRepository.saveOrUpdate(order);
    }


}
