package com.mail.domain.shared.event;

import com.mail.infrastructure.utils.SnowflakeIdGenerator;

public class EventIdGenerator {

    private final static EventIdGenerator INSTANCE = new EventIdGenerator();

    /**
     * 数据中心
     */
    private final String datacenter = "datacenter";
    /**
     * 机器节点
     */
    private final String node = "node";

    private final SnowflakeIdGenerator snowflakeIdGenerator;

    private EventIdGenerator() {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(0,0);
    }

    public static EventIdGenerator getInstance(){
        return INSTANCE;
    }
    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return 数据中心-机器节点-当前事件戳-号码内的序列号
     */
    public String generateId() {
        return this.datacenter+"-"+this.node+"-"+this.snowflakeIdGenerator.nextId();
    }
}
