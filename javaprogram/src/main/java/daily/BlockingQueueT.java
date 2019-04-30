package daily;

import mian.AbstractMain;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pfliu on 2019/04/28.
 */
public class BlockingQueueT extends AbstractMain {

    // 存放元素的linkedlist
    private LinkedList<Integer> items = new LinkedList<>();
    // 计数,使用AtomicInteger,防止冲突
    private AtomicInteger count = new AtomicInteger(0);

    //定义队列的最大值与最小值,也就是(满/空)的定义,当然这里可以用其他方式实现,比如用一个定长的数组.
    private final int max = 100;
    private final int min = 0;

    // 新建一个对象,用来充当锁的作用
    private final Object lock = new Object();

    public void put(Integer integer) throws InterruptedException {
        // 加锁
        synchronized (lock) {
            // 如果队列是满的,则当前线程不断的等待
            while (count.get() == max) {
                lock.wait();
            }
            // 添加元素,计数增加并且唤醒消费者
            items.add(integer);
            count.incrementAndGet();
            lock.notifyAll();
        }
    }

    public Integer pop() throws InterruptedException {
        // 加锁
        synchronized (lock) {
            // 如果队列是空的,则当前线程不断的等待
            while (count.get() == min) {
                lock.wait();
            }
            // 获取结果值,计数减少,唤醒消费者,返回结果
            Integer ret = items.getFirst();
            items.removeFirst();
            count.decrementAndGet();
            lock.notifyAll();
            return ret;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new BlockingQueueT().parseArgsAndRun(args);
    }

    @Override
    public void run() throws InterruptedException {
        BlockingQueueT bt = new BlockingQueueT();

        // 生成这线程,生成1000个元素
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                logger.info("add : {}", i);
                try {
                    bt.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.setName("producer");
        producer.start();
        // 消费者线程,秩序的进行消费
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    logger.info("get : {}", bt.pop());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumer.setName("consumer");
        consumer.start();
    }
}
