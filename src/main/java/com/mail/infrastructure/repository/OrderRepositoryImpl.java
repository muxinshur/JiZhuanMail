package com.mail.infrastructure.repository;

import com.alibaba.fastjson2.JSON;
import com.mail.domain.aggregate.order.entity.Order;
import com.mail.domain.aggregate.order.entity.valueObject.RecipientInformation;
import com.mail.domain.aggregate.order.repository.OrderRepository;
import com.mail.infrastructure.entity.OrderPo;
import com.mail.infrastructure.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void saveOrUpdate(Order order) {
        OrderPo orderPo = new OrderPo(order.getOrderId(),
                order.getBuyerId(),
                order.getSellerId(),
                order.getTotalAmount(),
                order.getDiscountAmount(),
                order.getPayAmount(),
                order.getFreightAmount(),
                order.getPayType(),
                order.getPayTime(),
                order.getExpressId(),
                order.getConfirmFlag(),
                JSON.toJSONString(order.getOrderItemList()),
                JSON.toJSONString(order.getRecipientInformation())
        );

    }

    @Override
    public Order find(long orderId) {
        OrderPo orderPo = orderMapper.selectOrderByOrderId(orderId);
        Order order = new Order(orderPo.getOrderId(),
                orderPo.getBuyerId(),
                orderPo.getSellerId(),
                orderPo.getTotalAmount(),
                orderPo.getDiscountAmount(),
                orderPo.getPayAmount(),
                orderPo.getFreightAmount(),
                orderPo.getPayType(),
                orderPo.getPayTime(),
                orderPo.getExpressId(),
                orderPo.getConfirmFlag(),
                JSON.parseObject(orderPo.getOrderItemList(), List.class),
                JSON.parseObject(orderPo.getRecipientInformation(), RecipientInformation.class)
                );
        return order;
    }
}
