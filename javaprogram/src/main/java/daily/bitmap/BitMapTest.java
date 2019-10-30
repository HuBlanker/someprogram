package daily.bitmap;

import java.util.BitSet;

/**
 * Created by pfliu on 2019/07/02.
 */
public class BitMapTest {
    // 实际使用int数组存储
    private int[] data;

    /**
     * 构造方法,传入预期的最大index.
     */
    public BitMapTest(int size) {
        this.data = new int[size >> 5];
    }

    /**
     * get 方法, 传入要获取的index, 返回bool值代表该位上为1/0
     */
    public boolean get(int bitIdx) {
        return (data[bitIdxToWorkIdx(bitIdx)] & (1 << bitIdx)) != 0;
    }

    /**
     * 将对应位置的值设置为传入的bool值
     */
    public void set(int idx, boolean v) {
        if (v) {
            set(idx);
        } else {
            clear(idx);
        }
    }

    // 将index的值设置为1
    private void set(int idx) {
        data[bitIdxToWorkIdx(idx)] |= 1 << idx;
    }

    // 将index上的值设置为0
    private void clear(int bitIdx) {
        data[bitIdxToWorkIdx(bitIdx)] &= ~(1L << bitIdx);
    }

    // 根据bit的index获取它存储的实际int在数组中的index
    private int bitIdxToWorkIdx(int bitIdx) {
        return bitIdx >> 5;
    }

    public static void main(String[] args) {

        BitMapTest t = new BitMapTest(100);
        t.set(10, true);

        System.out.println(t.get(9));
        System.out.println(t.get(10));

    }
}
