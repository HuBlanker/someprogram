package com.huyan;

/**
 * Created by pfliu on 2019/08/07.
 */
public class IntHashMap {
    private int[] keys;
    private int[] vals;
    private int size = 0;

    public IntHashMap(int capacity) {
        capacity = tableSizeFor(capacity);
        keys = new int[capacity];
        vals = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int get(int key) {
        int h = hash(key);
        int size_1 = keys.length - 1;

        final int LOOP_UNROLLING = 3;

        for (int i = 0; i < LOOP_UNROLLING; i++) {
            int idx = (h + i) & size_1;
            if (keys[idx] == key) return vals[idx];
            if (keys[idx] == 0) return 0;
        }

        for (int i = LOOP_UNROLLING; ; i++) {
            int idx = (h + i) & size_1;
            if (keys[idx] == key) return vals[idx];
            if (keys[idx] == 0) return 0;
        }
    }

    public boolean put(int key, int value) {
        if (this.size + (this.size >> 1) > keys.length) { // rehash
            int[] oldKeys = this.keys;
            int[] oldVals = this.vals;

            this.keys = new int[oldKeys.length * 2];
            this.vals = new int[oldKeys.length * 2];

            this.size = 0;
            for (int i = 0; i < oldKeys.length; i++) {
                if (oldKeys[i] != 0) {
                    put0(oldKeys[i], oldVals[i]);
                }
            }
        }

        return put0(key, value);
    }

    private boolean put0(int key, int value) {
        int h = hash(key);
        int size_1 = keys.length - 1;

        for (int i = 0; ; i++) {
            int idx = (h + i) & size_1;
            if (keys[idx] == 0) {
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

    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    // http://stackoverflow.com/questions/664014/what-integer-hash-function-are-good-that-accepts-an-integer-hash-key
    public static int hash(int x) {
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = (x >>> 16) ^ x;
        return x;
    }
}
