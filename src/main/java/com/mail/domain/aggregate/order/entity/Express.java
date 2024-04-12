package com.mail.domain.aggregate.order.entity;

import com.mail.domain.shared.BaseEntity;

/*
* 快递信息
* */
public class Express implements BaseEntity<Express> {

    /*
    * 快递单号
    * */
    private final String expressId;

    /*
    * 快递公司
    * */
    private final String expressCompany;

    /*
     * 构造方法
     * */
    public Express(String expressId, String expressCompany) {
        this.expressId = expressId;
        this.expressCompany = expressCompany;
    }

    /*
     * Getter
     * */
    public String getExpressId() {
        return expressId;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    /*
    * 聚合根相等判断
    * */
    @Override
    public boolean sameIdentityAs(Express other) {
        return other != null && expressId.equals(other.getExpressId());
    }
}
