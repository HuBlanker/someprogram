package util;


import org.apache.commons.lang3.time.StopWatch;

/**
 * Created by pfliu on 2019/04/20.
 */
public class StopWatchTest {


        public static void main(String[] args) throws InterruptedException {
            StopWatch watch = new StopWatch();
            watch.start();

            // 统计从start开始经历的时间
            Thread.sleep(1000);
            System.out.println("1-"+watch.getTime());

            // 统计计时点
            Thread.sleep(1000);
            watch.split();
            System.out.println("2-"+watch.getSplitTime());

            // 统计计时点
            Thread.sleep(1000);
            watch.split();
            System.out.println("3-"+watch.getSplitTime());

            // 复位后, 重新计时
            watch.reset();
            watch.start();
            Thread.sleep(1000);
            System.out.println("4-"+watch.getTime());

            // 暂停 与 恢复
            watch.suspend();
            System.out.println("暂停2秒钟");
            Thread.sleep(2000);

            watch.resume();
            Thread.sleep(1000);
            watch.stop();
            System.out.println("5-"+watch.getTime());
        }


}
