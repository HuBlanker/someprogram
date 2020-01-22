package com.huyan.collection;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.*;

import java.util.*;

/**
 * Author: huyanshi
 * Date:   2020/01/22.
 * Brief:  redis 实现的延迟队列 实现
 */
@Slf4j
public class DelayQueue {

    /**
     * 延迟队列的key
     */
    private final String key;

    /**
     * Jedispool
     */
    private final JedisPool jedisPool;

    /**
     * constructor
     *
     * @param key  key
     * @param host host
     */
    public DelayQueue(String key, String host) {
        this.key = key;
        this.jedisPool = new JedisPool(host);
    }

    /**
     * constructor
     *
     * @param key       key
     * @param jedisPool jedispool
     */
    public DelayQueue(String key, JedisPool jedisPool) {
        this.key = key;
        this.jedisPool = jedisPool;
    }

    /**
     * 获取当前延迟队列中元素的数量
     *
     * @return 数量
     */
    public long getDelaySize() {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.zcount(key, 0, Long.MAX_VALUE);
        }
    }

    /**
     * 向延迟队列中添加一个元素
     *
     * @param expireTs 元素的执行时间
     * @param member   元素的信息体.
     */
    public void putDelay(int expireTs, String member) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zadd(key, expireTs, member);
        }
    }

    /**
     * 删除元素
     *
     * @param members 元素名的集合
     */
    public void delDelay(String... members) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zrem(key, members);
        }
    }

    /**
     * 批量添加元素
     *
     * @param items 待添加的所有元素
     */
    public void putDelay(List<Item> items) {
        try (Jedis jedis = jedisPool.getResource()) {
            Pipeline pipeline = jedis.pipelined();
            List<Response<Long>> resp = new ArrayList<>(items.size());
            for (Item item : items) {
                resp.add(pipeline.zadd(key, item.expireTs, item.value));
            }
            pipeline.sync();
            int err = 0;
            for (Response<Long> r : resp) {
                Long reply = r.get();
                if (reply == null) {
                    err += 1;
                }
            }
            if (err > 0) {
                log.warn("put delays err: {}", err);
            }
        }
    }

    /**
     * 弹出当前要执行的任务
     *
     * @return 当前要执行的任务
     */
    public Set<Tuple> popNowExpires() {
        int now = (int) (System.currentTimeMillis() / 1000);
        return popRangeExpires(now);
    }

    /**
     * 弹出某个时间前执行的任务
     *
     * @return 当前要执行的任务
     */
    public Set<Tuple> popRangeExpires(int expireTs) {
        Set<Tuple> values = rangeExpires(expireTs);
        // del
        if (values.size() > 0) {
            delDelay(values.stream().map(Tuple::getElement).toArray(String[]::new));
        }
        return values;
    }

    /**
     * 查看某个时间以前的任务
     *
     * @param expireTs 执行时间
     * @return 任务集合
     */
    public Set<Tuple> rangeExpires(int expireTs) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.zrevrangeByScoreWithScores(key, expireTs, 0);
        }
    }

    /**
     * 根据过期时间批量移除元素
     *
     * @param start 开始时间
     * @param end   结束时间
     */
    public void remove(int start, int end) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zremrangeByRank(key, start, end);
        }
    }

    /**
     * 延迟队列中放的Item
     */
    public static class Item {
        public final String value;
        public final int expireTs;

        public Item(String value, int expireTs) {
            this.value = value;
            this.expireTs = expireTs;
        }

        @Override
        public String toString() {
            return value + ":" + expireTs;
        }
    }
}
