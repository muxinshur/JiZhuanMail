package com.mail.infrastructure.mapper;

import com.mail.infrastructure.entity.OrderPo;

public interface OrderMapper {

    public int insert(OrderPo orderPo);

    public OrderPo selectOrderByOrderId(Long orderId);

}
