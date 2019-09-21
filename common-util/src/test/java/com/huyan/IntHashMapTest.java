package com.huyan;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.util.*;

public class IntHashMapTest {

    static final int NUM = 10000000;

    @Test
    public void t() {
//        // 7,8 万的亚子
//        Ticker ticker = new Ticker();
//        IntHashMap intHashMap = new IntHashMap(1 << 16);
//
//        Random r = new Random();
//
//        for (int i = 0; i < NUM; i++) {
//            int key = r.nextInt(NUM);
//            intHashMap.put(key, key + 2);
//        }
//
//        for (int i = 0; i < NUM; i++) {
//            int j = intHashMap.get(r.nextInt(NUM));
//        }
//
//        ticker.tick("inthashmap");
//
//        Map<Integer, Integer> map = new HashMap<>(1 << 16);
//        Random r1 = new Random();
//
//        for (int i = 0; i < NUM; i++) {
//            int key = r1.nextInt(NUM);
//            map.put(key, key + 2);
//        }
//
//        for (int i = 0; i < NUM; i++) {
//            Integer a = map.get(r1.nextInt(NUM));
//        }
//        ticker.tick("hashmap");
//        System.out.println(ObjectSizeCalculator.getObjectSize(intHashMap));
//        System.out.println(ObjectSizeCalculator.getObjectSize(map));
//        System.out.println(ticker.toString());
//        System.out.println(1215044 % 1000000);

//        Map<Long, Float> a = new HashMap<>();
//        LongFloatHashMap b = new LongFloatHashMap(10);
//
////        b.put(10L, 0.1f);
//////        System.out.println(a.get(1L));
////        System.out.println(b.get(1L));
////        System.out.println(b.getOrDefault(10L,-999));
////
////        String s = null;
////        System.out.println(s.toLowerCase());
////
////        System.out.println(b.get(1L) == 0);
//
////        System.out.println(1 << 16);
////        HashMap
//        b.put((long) 1 << 32 + 1, 0.1f);
//
//        System.out.println(b.get((long)1 << 32 + 1));

        int[] a = new int[10];

        a[0] = 1;


        test(a);
        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void test(int [] a) {
        a[5] = 10;
    }
}