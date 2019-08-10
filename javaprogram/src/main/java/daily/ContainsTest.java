package daily;

import com.googlecode.javaewah.EWAHCompressedBitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfliu on 2019/07/22.
 */
public class ContainsTest {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            a.add(i);
        }

        long d1 = System.nanoTime();

        System.out.println(a.contains(999999));

        System.out.println(System.nanoTime() - d1);


        EWAHCompressedBitmap map = new EWAHCompressedBitmap();
        for (int i = 0; i < 300000; i++) {
            map.set(i);
        }
        long d = System.nanoTime();
        System.out.println(map.get(999999));
        System.out.println(System.nanoTime() - d);
    }
}
