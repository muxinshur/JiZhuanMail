package com.mail.domain.service.impl;

import com.mail.domain.aggregate.order.OrderIdGenerator;
import com.mail.domain.aggregate.order.entity.Order;
import com.mail.domain.aggregate.order.entity.valueObject.RecipientInformation;
import com.mail.domain.aggregate.order.entity.valueObject.OrderItem;
import com.mail.domain.aggregate.order.repository.OrderRepository;
import com.mail.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Long buyerId, Long sellerId, List<OrderItem> orderItemList, RecipientInformation recipientInformation) {
        Order order = new Order(OrderIdGenerator.getInstance().generateId(), buyerId, sellerId, orderItemList, recipientInformation);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateDiscountAmount(Long orderId, BigDecimal discountAmount) {
        Order order = orderRepository.find(orderId);
        order.setDiscountAmount(discountAmount);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateFreightAmount(Long orderId, BigDecimal freightAmount) {
        Order order = orderRepository.find(orderId);
        order.setFreightAmount(freightAmount);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateExpressId(Long orderId, String expressId) {
        Order order = orderRepository.find(orderId);
        order.setExpressId(expressId);
        order.setConfirmFlag(0);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void updateRecipientInformation(Long orderId, RecipientInformation recipientInformation) {
        Order order = orderRepository.find(orderId);
        order.setRecipientInformation(recipientInformation);
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public void afterPay(Long orderId, Integer payType, Date payTime) {
        Order order = orderRepository.find(orderId);
        order.setConfirmFlag(1);
    }
}
