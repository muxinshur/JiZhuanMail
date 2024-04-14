package com.mail.infrastructure.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderPo {

    /*
     * 订单ID
     * */
    private long orderId;

    /*
     * 买家ID
     * */
    private long buyerId;

    /*
     * 卖家ID
     * */
    private long sellerId;

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
    private String orderItemList;

    /*
     * 收件人信息
     * */
    private String recipientInformation;

    public OrderPo() {
    }

    public OrderPo(long orderId, long buyerId, long sellerId, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal payAmount, BigDecimal freightAmount, Integer payType, Date payTime, String expressId, Integer confirmFlag, String orderItemList, String recipientInformation) {
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public Integer getConfirmFlag() {
        return confirmFlag;
    }

    public void setConfirmFlag(Integer confirmFlag) {
        this.confirmFlag = confirmFlag;
    }

    public String getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(String orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getRecipientInformation() {
        return recipientInformation;
    }

    public void setRecipientInformation(String recipientInformation) {
        this.recipientInformation = recipientInformation;
    }
}
