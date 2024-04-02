package com.mail.domain.order.service;

import com.mail.domain.order.domain.aggregate.entity.valueObject.Address;
import com.mail.domain.order.domain.aggregate.entity.valueObject.OrderItem;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderService {

    public void createOrder(String buyerId, String sellerId, Set<OrderItem> orderItemList, Address address);

    public void updateDiscountPrice(long orderId, BigDecimal discountPrice);

    public void updateExpressId(long orderId, String expressId);

    public void updateExpressPrice(long orderId, BigDecimal expressPrice);

    public void updateAddress(long orderId, Address address);

}
