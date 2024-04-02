package com.mail.domain.order.domain.aggregate.entity;

import com.mail.domain.common.BaseEntity;
import com.mail.domain.order.domain.aggregate.entity.valueObject.Address;
import com.mail.domain.order.domain.aggregate.entity.valueObject.OrderItem;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/*订单信息*/
public class Order implements BaseEntity<Order> {

    /*订单ID*/
    private final long orderId;

    /*买家ID*/
    private final String buyerId;

    /*卖家ID*/
    private final String sellerId;

    /*订单优惠金额*/
    private BigDecimal discountPrice;

    /*订单快递信息*/
    private String expressId;

    /*运费*/
    private BigDecimal expressPrice;

    /*订单商品列表*/
    private final Set<OrderItem> orderItemList;

    /*订单收件人信息*/
    private Address address;

    public Order(long orderId, String buyerId, String sellerId, Set<OrderItem> orderItemList, Address address) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.orderItemList = orderItemList;
        this.address = address;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public String getExpressId() {
        return expressId;
    }

    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    public Set<OrderItem> getOrderItemList() {
        return Collections.unmodifiableSet(orderItemList);
    }

    public Address getAddress() {
        return address;
    }

    /*校验是否为正值*/
    public boolean isNotNegative(BigDecimal value){
        return value.compareTo(BigDecimal.ZERO) >= 0;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        if (isNotNegative(discountPrice)) {
            this.discountPrice = discountPrice;
        }else {
            throw new IllegalArgumentException("订单优惠金额不能小于0");
        }
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public void setExpressPrice(BigDecimal expressPrice) {
        if (isNotNegative(discountPrice)) {
            this.expressPrice = expressPrice;
        }else {
            throw new IllegalArgumentException("运费不能小于0");
        }
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean sameIdentityAs(Order other) {
        return other != null && orderId == other.getOrderId();
    }

    public BigDecimal getItemPrice() {
        return orderItemList.stream()
                .map(OrderItem::getItemPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = getItemPrice().add(getExpressPrice());
        if (Objects.nonNull(discountPrice)){
            totalPrice = totalPrice.subtract(discountPrice);
        }
        return totalPrice;
    }
}
