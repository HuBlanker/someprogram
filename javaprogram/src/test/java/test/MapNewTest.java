package test;

import com.google.common.collect.BiMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pfliu on 2019/05/13.
 */
public class MapNewTest {


    @Test
    public void test1() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        test.replaceAll((k, v) -> k + v);
        System.out.println(test.toString());
    }

    @Test
    public void test2() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        test.putIfAbsent(1, 3);
        test.putIfAbsent(3, 3);
        System.out.println(test.toString());
    }

    @Test
    public void test3() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        // 1 存在,不做任何操作
        test.computeIfAbsent(1, key -> key + 2);
        // 3 不存在,将3 +2 = 5.
        test.computeIfAbsent(3, key -> key + 2);
        System.out.println(test.toString());
    }

    @Test
    public void test4() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        // 1 存在,计算
        test.computeIfPresent(1, (key, oldValue) -> key + oldValue + 2);
        // 3 不存在,不作操作
        test.computeIfPresent(3, (key, oldValue) -> key + oldValue + 2);
        System.out.println(test.toString());
    }

    @Test
    public void test5() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        test.compute(1, (key, oldValue) -> key + 2);
        test.compute(3, (key, oldValue) -> key + 2);
        test.compute(2, (key, oldValue) -> null);
        System.out.println(test.toString());
    }

    @Test
    public void test6() {
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.toString());

        test.merge(1, 10, (v, oldV) -> v + oldV + 2);
        test.merge(3, 10, (v, oldV) -> v + oldV + 2);
        test.merge(2, 10, (v, oldV) -> null);
        System.out.println(test.toString());

    }
}
