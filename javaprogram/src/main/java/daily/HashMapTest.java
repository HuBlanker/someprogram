package daily;

import mian.AbstractMain;

import java.util.*;

/**
 * Created by pfliu on 2019/09/09.
 */
public class HashMapTest extends AbstractMain {
    @Override
    public void run() {
        // int->(int->double)
        Map<Integer, Map<Integer, Double>> a = new HashMap<>();
        Map<Integer, Double> value = new HashMap<>();
        value.put(2, 0.2);
        a.put(1, value);

        //long->double
        Map<Long, Double> b = new HashMap<>();
        b.put((1L << 32) + 2, 0.2);

        Double aDouble = a.get(1).get(2);
        System.out.println(aDouble);
        Double obj = b.get((1L << 32) + 2);
        System.out.println(obj);
        System.out.println(aDouble.equals(obj));

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            a.get(1).get(2);
        }
        long t2 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            b.get((1L << 32) + 2);
        }

        long t3 = System.currentTimeMillis();

        System.out.println("a:" + (t2 - t1) + ", b:" + (t3 - t2) + ", bili:" + ((t3 - t2) * 1.0 / (t2 - t1)));

    }

    public static void main(String[] args) {
        new HashMapTest().parseArgsAndRun(args);
    }
}
