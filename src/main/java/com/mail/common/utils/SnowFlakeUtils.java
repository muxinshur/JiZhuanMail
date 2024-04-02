package com.mail.common.utils;

import org.springframework.stereotype.Component;

@Component
public class SnowFlakeUtils {

    private static final long EPOCH = 1577836800000L; // 自定义的时间起点，单位是毫秒，默认设置为2020年1月1日零点

    private static final long SEQUENCE_BITS = 12; // 序列号位数
    private static final long WORKER_ID_BITS = 10; // 工作机器标识位数
    private static final long DATACENTER_ID_BITS = 5; // 数据中心标识位数

    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    private static final long SEQUENCE_MASK = MAX_SEQUENCE;

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowFlakeUtils(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("机器号超过 %d 或小于 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("数据中心号超过 %d 或小于 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException("时钟回拨，拒绝为 " + (lastTimestamp - timestamp) + " milliseconds" + "生成ID");
        }

        if (lastTimestamp == timestamp) {
            // 当前时间戳与上一次相同，序列号自增
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 如果序列号溢出，则等待下一毫秒
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳不同，序列号重置
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // 组装64位ID
        return ((timestamp - EPOCH) << TIMESTAMP_LEFT_SHIFT) |
               (datacenterId << DATACENTER_ID_SHIFT) |
               (workerId << WORKER_ID_SHIFT) |
               sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }
}
