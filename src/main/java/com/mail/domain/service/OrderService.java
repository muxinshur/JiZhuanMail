package com.mail.domain.service;

import com.mail.domain.aggregate.order.entity.valueObject.RecipientInformation;
import com.mail.domain.aggregate.order.entity.valueObject.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderService {

    public void createOrder(Long buyerId, Long sellerId, List<OrderItem> orderItemList, RecipientInformation recipientInformation);

    public void updateDiscountAmount(Long orderId, BigDecimal discountPrice);

    public void updateFreightAmount(Long orderId, BigDecimal freightPrice);

    public void updateExpressId(Long orderId, String expressId);

    public void updateRecipientInformation(Long orderId, RecipientInformation recipientInformation);

    public void afterPay(Long orderId, Integer payType, Date payTime);

}
