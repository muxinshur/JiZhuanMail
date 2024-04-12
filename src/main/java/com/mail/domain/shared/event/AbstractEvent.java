package com.mail.domain.shared.event;

import com.alibaba.fastjson2.JSON;

import java.util.Date;

public abstract class AbstractEvent<T> implements DomainEvent {

    private final String id;
    private final Date timestamp;
    private final T data;
    public AbstractEvent(T data){
        this.id = EventIdGenerator.getInstance().generateId();
        this.timestamp = new Date();
        this.data = data;
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public Date timestamp() {
        return this.timestamp;
    }

    @Override
    public boolean sameEventAs(DomainEvent other) {
        return this.id().equals(other.id());
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
