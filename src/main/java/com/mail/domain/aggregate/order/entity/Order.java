package com.mail.domain.aggregate.order.entity;

import com.mail.domain.aggregate.order.entity.valueObject.RecipientInformation;
import com.mail.domain.aggregate.order.entity.valueObject.OrderItem;
import com.mail.domain.shared.BaseEntity;

import java.math.BigDecimal;
import java.util.*;

/*
* 订单聚合根
* */
public class Order implements BaseEntity<Order> {

    /*
    * 订单ID
    * */
    private final long orderId;

    /*
    * 买家ID
    * */
    private final long buyerId;

    /*
    * 卖家ID
    * */
    private final long sellerId;

    /*
    * 订单总金额
    * */
    private BigDecimal totalAmount;

    /*
    * 优惠金额
    * */
    private BigDecimal discountAmount;

    /*
    * 支付金额
    * */
    private BigDecimal payAmount;

    /*
    * 运费金额
    * */
    private BigDecimal freightAmount;

    /*
    * 支付方式
    * */
    private Integer payType;

    /*
    * 支付时间
    * */
    private Date payTime;

    /*
    * 快递单号
    * */
    private String expressId;

    /*
    * 收货状态
    * 0：未接收
    * 1：已接收
    * */
    private Integer confirmFlag;

    /*
    * 商品列表
    * */
    private final List<OrderItem> orderItemList;

    /*
    * 收件人信息
    * */
    private RecipientInformation recipientInformation;

    /*
    * 构造方法
    * */
    public Order(long orderId, long buyerId, long sellerId, List<OrderItem> orderItemList, RecipientInformation recipientInformation) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.orderItemList = orderItemList;
        this.recipientInformation = recipientInformation;
    }

    public Order(long orderId, long buyerId, long sellerId, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal payAmount, BigDecimal freightAmount, Integer payType, Date payTime, String expressId, Integer confirmFlag, List<OrderItem> orderItemList, RecipientInformation recipientInformation) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.payAmount = payAmount;
        this.freightAmount = freightAmount;
        this.payType = payType;
        this.payTime = payTime;
        this.expressId = expressId;
        this.confirmFlag = confirmFlag;
        this.orderItemList = orderItemList;
        this.recipientInformation = recipientInformation;
    }

    /*
     * Getter
     * */
    public Date getPayTime() {
        return payTime;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public String getExpressId() {
        return expressId;
    }

    public Integer getConfirmFlag() {
        return confirmFlag;
    }

    public RecipientInformation getRecipientInformation() {
        return recipientInformation;
    }

    /*
    * 防止OrderItemList指针指向的List被替换
    * */
    public List<OrderItem> getOrderItemList() {
        return Collections.unmodifiableList(orderItemList);
    }

    /*
    * Setter
    * */
    public void setTotalAmount() {
        this.totalAmount = this.orderItemList.stream()
                .map(OrderItem::getItemPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public void setPayAmount() {
        this.payAmount = this.totalAmount.subtract(discountAmount).add(freightAmount);
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public void setConfirmFlag(Integer confirmFlag) {
        this.confirmFlag = confirmFlag;
    }

    public void setRecipientInformation(RecipientInformation recipientInformation) {
        this.recipientInformation = recipientInformation;
    }

    /*
     * 聚合根相等判断
     * */
    @Override
    public boolean sameIdentityAs(Order other) {
        return other != null && orderId == other.getOrderId();
    }
}
