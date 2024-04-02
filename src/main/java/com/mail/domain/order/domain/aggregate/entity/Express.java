package com.mail.domain.order.domain.aggregate.entity;

import com.mail.domain.common.BaseEntity;

/*快递信息*/
public class Express implements BaseEntity<Express> {

    /*快递单号*/
    private final String expressId;

    /*快递公司*/
    private final String expressCompany;

    public Express(String expressId, String expressCompany) {
        this.expressId = expressId;
        this.expressCompany = expressCompany;
    }

    public String getExpressId() {
        return expressId;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    @Override
    public boolean sameIdentityAs(Express other) {
        return other != null && expressId.equals(other.getExpressId());
    }
}
