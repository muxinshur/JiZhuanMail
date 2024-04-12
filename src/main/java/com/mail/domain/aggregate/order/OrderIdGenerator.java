package com.mail.domain.aggregate.order;

import com.mail.domain.shared.event.EventIdGenerator;
import com.mail.infrastructure.utils.SnowflakeIdGenerator;

public class OrderIdGenerator {

    private final static OrderIdGenerator INSTANCE = new OrderIdGenerator();

    /**
     * 数据中心
     */
    private final String datacenter = "datacenter";
    /**
     * 机器节点
     */
    private final String node = "node";

    private final SnowflakeIdGenerator snowflakeIdGenerator;

    private OrderIdGenerator() {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(0,0);
    }

    public static OrderIdGenerator getInstance(){
        return INSTANCE;
    }
    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return 数据中心-机器节点-当前事件戳-号码内的序列号
     */
    public long generateId() {
        return this.snowflakeIdGenerator.nextId();
    }

}
