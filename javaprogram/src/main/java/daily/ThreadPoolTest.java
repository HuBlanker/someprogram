package daily;

import mian.AbstractMain;

import java.util.concurrent.*;

/**
 * Created by pfliu on 2019/05/05.
 */
public class ThreadPoolTest extends AbstractMain {


    @Override
    public void run() {

        ThreadPoolExecutor ex = new MyExecutor(10, 100, 100L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new MyRejectPolicy());
        ex.execute(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println("i:" + i);
            }
        });

        ex.execute(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println("j:" + i);
            }
        });

        ex.shutdown();
    }

    private static class MyRejectPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("reject me,555");
            // send email ...
        }
    }


    public static void main(String[] args) {
        new ThreadPoolTest().parseArgsAndRun(args);
    }

    private static class MyExecutor extends ThreadPoolExecutor {


        public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println("before");
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            System.out.println("after");
        }

        @Override
        protected void terminated() {
            System.out.println("executor terminate");

        }
    }
}
