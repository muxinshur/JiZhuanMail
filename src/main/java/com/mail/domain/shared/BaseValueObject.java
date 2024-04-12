package com.mail.domain.shared;

public interface BaseValueObject<T> {

    /*值对象通过属性进行比较*/
    boolean sameValueAs(T other);

}
