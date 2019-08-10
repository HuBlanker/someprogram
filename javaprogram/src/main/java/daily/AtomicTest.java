package daily;

import mian.AbstractMain;
import mian.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by pfliu on 2019/04/23.
 */
public class AtomicTest extends AbstractMain {


    public static void main(String[] args) {

        new AtomicTest().parseArgsAndRun(args);
    }

    @Override
    public void run() {

//        AtomicInteger a = new AtomicInteger(0);
////
////        logger.info(a.incrementAndGet() + "");
////        logger.info(a.getAndIncrement() + "");
////
////        logger.info(a.decrementAndGet() + "");
////        logger.info(a.getAndDecrement() + "");
////
////        int[] aaa = {1, 2, 3};
////
////        Stream.of(aaa).forEach(System.out::println);
////
////        logger.info(a.getAndSet(11) + "");
////        a.set(22);
////        logger.info(a.get() + "");
////
////
////        System.out.println();

        String s = "14:00:00";
        String s1 = "16:00:00";

//        System.out.println(s.compareTo(s1));
//        System.out.println(10L << 32 + 87L);
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 3);
        System.out.println(a.get("b"));
    }
}
