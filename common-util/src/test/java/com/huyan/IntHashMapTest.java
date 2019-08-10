package com.huyan;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class IntHashMapTest {

    @Test
    public void t() {
        // 7,8 万的亚子
        Ticker ticker = new Ticker();
        IntHashMap intHashMap = new IntHashMap(1 << 16);

        Random r = new Random();

        for (int i = 0; i < 10000; i++) {
            int key = r.nextInt(1000000);
            intHashMap.put(key, key + 2);
        }

        for (int i = 0; i < 100000; i++) {
            System.out.println(intHashMap.get(r.nextInt(1000000)));
        }

        ticker.tick("inthashmap");

        Map<Integer, Integer> map = new HashMap<>(1 << 16);
        Random r1 = new Random();

        for (int i = 0; i < 10000; i++) {
            int key = r1.nextInt(1000000);
            map.put(key, key + 2);
        }

        for (int i = 0; i < 100000; i++) {
            System.out.println(map.get(r1.nextInt(1000000)));
        }
        ticker.tick("hashmap");
        System.out.println(ObjectSizeCalculator.getObjectSize(intHashMap));
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(ticker.toString());

    }
}