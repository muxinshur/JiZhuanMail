package com.mail.domain.common;

public interface BaseEntity<T> {

    /*实体通过唯一ID进行比较*/
    boolean sameIdentityAs(T other);

}
