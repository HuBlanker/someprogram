package daily.counter;

import com.google.common.base.Ticker;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pfliu on 2019/04/21.
 */
public class Counter1 {

    private static Map<String, Integer> count1(List<String> stringList) {
        HashMap<String, Integer> c = new HashMap<>();
        stringList.forEach(per -> {
            c.put(per, c.getOrDefault(per, 0) + 1);
        });
        return c;
    }

    private static Map<String, MutableInteger> count2(List<String> strings) {
        HashMap<String, MutableInteger> c = new HashMap<>();
        strings.forEach(per -> {
            MutableInteger init = new MutableInteger(1);
            MutableInteger last = c.put(per, init);
            if (last != null) {
                init.set(last.get() + 1);
            }
        });
        return c;
    }

    private static int count3(List<String> strings) {
        Jedis j = new Jedis("127.0.0.1");
        strings.forEach(j::incr);
        return 1;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] ss = {"my", "aa", "cc", "aa", "cc", "b", "w", "sssssa", "10", "10"};

        for (int i = 0; i < 100000000; i++) {
            list.add(ss[i % 10]);
        }
        long s = System.currentTimeMillis();
        System.out.println(count1(list));
        System.out.println(System.currentTimeMillis() - s);

        long s1 = System.currentTimeMillis();
        System.out.println(count2(list));
        System.out.println(System.currentTimeMillis() - s1);


        long s2 = System.currentTimeMillis();
        System.out.println(count3(list));
        System.out.println(System.currentTimeMillis() - s2);

    }


    public static final class MutableInteger {
        private int val;

        public MutableInteger(int val) {
            this.val = val;
        }

        public int get() {
            return this.val;
        }

        public void set(int val) {
            this.val = val;
        }

        public String toString() {
            return Integer.toString(val);
        }
    }


}
