package daily;

import com.google.common.collect.*;
import mian.AbstractMain;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by pfliu on 2019/05/01.
 */
public class GuavaColTest extends AbstractMain {
    @Override
    public void run() {

        ArrayListMultimap<String, String> userSign = ArrayListMultimap.create();
        userSign.put("huyan", "2019-05-01");
        userSign.put("huyan", "2019-05-02");

        Multiset<String> s = HashMultiset.create();
        s.add("pf");
        s.add("pf");
        s.add("pf");
        s.add("hh");

        int i = s.count("pf");


        BiMap<String, String> m = HashBiMap.create();

        m.put("pf", "111");

        String value = m.get("pf");
        String key = m.inverse().get("111");

        int k = 0;


        ConcurrentMap<String, Object> map4 = new MapMaker()
                .makeMap();

        List<Student> students = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        Ordering<Student> studentOrdering = Ordering.compound(Arrays.asList((o1, o2) -> {
            return ComparisonChain.start().result();
        }, (o1, o2) -> 0, (o1, o2) -> 0));
        Collections.sort(students, studentOrdering);

        Table<Integer, Integer, String> tt = HashBasedTable.create();
        tt.put(1, 2, "huyan");

        String name = tt.get(1, 2);
        Map<Integer, String> row = tt.row(1);
        Map<Integer, String> colum = tt.column(1);
        Set<Table.Cell<Integer, Integer, String>> ha = tt.cellSet();

        System.out.println("123".compareTo("122"));

    }


    private static class Student implements Comparable {
        int id;
        String name;
        int age;

        @Override
        public int compareTo(Object o) {
            return this.id - ((Student) o).id;
        }
    }

    private static class StudentCom1 implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void main(String[] args) {
        new GuavaColTest().parseArgsAndRun(args);
    }
}
