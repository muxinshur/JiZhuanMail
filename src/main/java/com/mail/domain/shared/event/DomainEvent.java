package com.mail.domain.shared.event;

import java.util.Date;

public interface DomainEvent {
    /**
     * 返回事件的唯一ID
     * @return 事件的唯一ID
     */
    String id();

    /**
     * 返回事件的产生的时间
     * @return 事件的产生的时间
     */
    Date timestamp();
    /**
     * 判断领域事件是否一致
     * @param other 另外一个领域事件
     * @return <code>true</code> 如果当前比较的两个领域事件一致返回true
     */
    boolean sameEventAs(DomainEvent other);
}
