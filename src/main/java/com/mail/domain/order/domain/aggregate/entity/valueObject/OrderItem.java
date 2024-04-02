package com.mail.domain.order.domain.aggregate.entity.valueObject;

import com.mail.domain.common.BaseValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;

/*子订单*/
public class OrderItem implements BaseValueObject<OrderItem> {

    /*商品ID*/
    private final long itemId;

    /*商品SPU（商品参数信息）ID*/
    private final long spuId;

    /*商品SKU（具体颜色、配置等参数）ID*/
    private final long skuId;

    /*商品数量*/
    private final int amount;

    /*商品单价*/
    private final BigDecimal unitPrice;

    /*商品快照*/
    private final Object snapshot;

    public OrderItem(long itemId, long spuId, long skuId, int amount, BigDecimal unitPrice, Object snapshot) {
        this.itemId = itemId;
        this.spuId = spuId;
        this.skuId = skuId;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.snapshot = snapshot;
    }

    public long getItemId() {
        return itemId;
    }

    public long getSpuId() {
        return itemId;
    }

    public long getSkuId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Object getSnapshot() {
        return snapshot;
    }

    @Override
    public boolean sameValueAs(OrderItem other) {
        return other != null && new EqualsBuilder().
                append(itemId, other.getItemId()).
                append(spuId, other.getSpuId()).
                append(skuId, other.getSkuId()).
                append(amount, other.getAmount()).
                append(unitPrice, other.getUnitPrice()).
                append(snapshot, other.getSnapshot()).
                isEquals();
    }

    public BigDecimal getItemPrice() {
        return unitPrice.multiply(new BigDecimal(amount));
    }
}
