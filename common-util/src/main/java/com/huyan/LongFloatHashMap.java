package com.huyan;

import static com.huyan.IntHashMap.hash;
import static com.huyan.IntHashMap.tableSizeFor;

/**
 * long -> long   比较特殊的hashmap的实现， 仅提供get, put两个接口
 * 有两个优势：
 * 1. 速度比HashMap要快一点 (136ms vs 55ms)
 * 2. 内存紧凑一些，对gc友好
 */
public class LongFloatHashMap {
    private long[] keys;
    private float[] vals;
    private int size = 0;

    public LongFloatHashMap(int capacity) {
        capacity = tableSizeFor(capacity);
        keys = new long[capacity];
        vals = new float[capacity];
    }

    public int size() {
        return size;
    }

    public float get(long key) {
        int h = hash((int) key);
        int size_1 = keys.length - 1;

        final int LU = 3;

        for (int i = 0; i < LU; i++) {
            int idx = (h + i) & size_1;
            if (keys[idx] == key) return vals[idx];
            if (keys[idx] == 0.0f) return 0;
        }

        for (int i = h + LU; ; i++) {
            int idx = i & size_1;
            if (keys[idx] == key) return vals[idx];
            if (keys[idx] == 0.0f) return 0;
        }
    }


    public boolean put(long key, float value) {
        if (this.size + (this.size >> 1) > keys.length) { // rehash
            long[] oldKeys = this.keys;
            float[] oldVals = this.vals;

            this.keys = new long[oldKeys.length * 2];
            this.vals = new float[oldKeys.length * 2];

            this.size = 0;
            for (int i = 0; i < oldKeys.length; i++) {
                if (oldKeys[i] != 0.0f) {
                    put0(oldKeys[i], oldVals[i]);
                }
            }
        }

        return put0(key, value);
    }

    private boolean put0(long key, float value) {
        int h = hash((int) key);
        int size_1 = keys.length - 1;

        for (int i = 0; ; i++) {
            int idx = (h + i) & size_1;
            if (keys[idx] == 0.0f) {
                keys[idx] = key;
                vals[idx] = value;
                this.size += 1;
                return true;
            } else if (keys[idx] == key) { // replace
                vals[idx] = value;
                return false;
            }
        }
    }


    public float getOrDefault(long key, float d) {
        float v = get(key);
        return v == 0 ? d : v;
    }

}

