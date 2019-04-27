package daily.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pfliu on 2019/04/21.
 */
public class Counter<T extends Object> {

    private HashMap<T, MutableInteger> c = new HashMap<>();

    public void add(T t) {
        MutableInteger init = new MutableInteger(1);
        MutableInteger last = c.put(t, init);
        if (last != null) {
            init.set(last.get() + 1);
        }
    }

    public void addAll(List<T> list) {
        list.forEach(this::add);
    }
    public int get(T t) {
        return c.get(t).val;
    }

    public Map<T, Integer> getAll() {
        Map<T, Integer> ret = new HashMap<>();
        c.forEach((key, value) -> ret.put(key, value.val));
        return ret;
    }

    public static final class MutableInteger {

        private int val;

        MutableInteger(int val) {
            this.val = val;
        }

        public int get() {
            return this.val;
        }

        void set(int i) {
            this.val = i;
        }
    }
}
