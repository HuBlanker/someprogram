package daily;

import mian.AbstractMain;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by pfliu on 2019/04/28.
 */
public class BlockingQueueTest extends AbstractMain {
    ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        new BlockingQueueTest().parseArgsAndRun(args);
    }

    @Override
    public void run() {
        Thread consume = new Thread(() -> {
            try {
                t1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer = new Thread(()->{
            try {
                t2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        consume.start();
        producer.start();
    }

    private void t1() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            abq.put(i);
            logger.info("add to queue: {}", i);
        }
        logger.info("queue size = {}", abq.size());
    }

    private void t2() throws InterruptedException {
        while (true) {
            logger.info("take one : {}", abq.take());
        }
    }
}
