package com.mail.domain.aggregate.order.entity.valueObject;

import com.mail.domain.shared.BaseValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;

/*
* 子订单
* */
public class OrderItem implements BaseValueObject<OrderItem> {

    /*
    * 订单ID
    * */
    private final Long orderId;

    /*
    * 商品SPU ID
    * */
    private final Long spuId;

    /*
    * 商品SKU ID
    * */
    private final Long skuId;

    /*
    * 商品数量
    * */
    private final Integer amount;

    /*
    * 商品单价
    * */
    private final BigDecimal unitPrice;

    /*
    * 商品快照
    * */
    private final Object snapshot;

    /*
     * 构造方法
     * */
    public OrderItem(Long orderId, Long spuId, Long skuId, Integer amount, BigDecimal unitPrice, Object snapshot) {
        this.orderId = orderId;
        this.spuId = spuId;
        this.skuId = skuId;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.snapshot = snapshot;
    }

    /*
     * Getter
     * */
    public Long getOrderId() {
        return orderId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Object getSnapshot() {
        return snapshot;
    }

    /*
    * 计算子订单总价
    * */
    public BigDecimal getItemPrice() {
        return unitPrice.multiply(new BigDecimal(amount));
    }

    /*
     * 值对象相等判断
     * */
    @Override
    public boolean sameValueAs(OrderItem other) {
        return other != null && new EqualsBuilder().
                append(orderId, other.getOrderId()).
                append(spuId, other.getSpuId()).
                append(skuId, other.getSkuId()).
                append(amount, other.getAmount()).
                append(unitPrice, other.getUnitPrice()).
                append(snapshot, other.getSnapshot()).
                isEquals();
    }
}
