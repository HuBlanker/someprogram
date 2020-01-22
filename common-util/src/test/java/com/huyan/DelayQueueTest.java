package com.huyan.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.*;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.*;

import static org.junit.Assert.*;

public class DelayQueueTest {

    DelayQueue queue = new DelayQueue("my_queue", "localhost");

    //    @Before
//    public void setUp() throws Exception {
//
//    }

    @Test
    public void deleyQueueTest() {
        int oneHourLater = (int) (System.currentTimeMillis() / 1000 + 3600);
        queue.putDelay(oneHourLater, "test_1");
        Assert.assertEquals(1, queue.getDelaySize());
        int twoHourLater = (int) (System.currentTimeMillis() / 1000 + 7200);
        queue.putDelay(twoHourLater, "test_2");
        Assert.assertEquals(2, queue.getDelaySize());
        queue.popNowExpires();
        Assert.assertEquals(2, queue.getDelaySize());
        queue.rangeExpires(oneHourLater + 100);
        Assert.assertEquals(2, queue.getDelaySize());
        queue.delDelay("test_2");
        Assert.assertEquals(1, queue.getDelaySize());
        queue.popRangeExpires(oneHourLater + 100);
        Assert.assertEquals(0, queue.getDelaySize());
    }

    @Test
    public void delayQueueProducer() {

        // 单个生产
        int now = (int) (System.currentTimeMillis() / 1000);
        queue.putDelay(now, "your_message_body");

        // 批量生产
        List<DelayQueue.Item> items = new ArrayList<>();
        items.add(new DelayQueue.Item("your_message_body", now));
        queue.putDelay(items);
    }

    @Test
    public void delayQueueConsumer() throws InterruptedException {

        // 轮询消费当前应该执行的任务, 或者调用popRangeExpires消费某个时间之前的所有任务
        int now = (int) (System.currentTimeMillis() / 1000);
        while (true) {
            Set<Tuple> tuples = queue.popNowExpires();
            // 为空休眠一秒
            if (CollectionUtils.isEmpty(tuples)) {
                Thread.sleep(1000);
                continue;
            }
            // 处理业务逻辑
            System.out.println("do something");
        }
    }
}