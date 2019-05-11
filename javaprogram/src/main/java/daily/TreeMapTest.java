package daily;

import mian.AbstractMain;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by pfliu on 2019/05/01.
 */
public class TreeMapTest extends AbstractMain {
    @Override
    public void run() {


        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(1, "huyan");
        t.put(2, "hh");
        t.put(3, "xixi");

        // get
        String name = t.get(1);
        // 获取第一个/最后一个key
        Integer firstKey = t.firstKey();
        Integer lastKey = t.lastKey();
        // 弹出第一个/最后一个entry
        Map.Entry firstEntry = t.pollFirstEntry();
        Map.Entry lastEntry = t.pollLastEntry();

        t.ceilingKey(1);
        // 清空
        t.clear();

    }


    public static void main(String[] args) {
        new TreeMapTest().parseArgsAndRun(args);
    }
}
