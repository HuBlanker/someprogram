package daily;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by pfliu on 2019/10/24.
 */
public class BoxTest {
    public static void main(String [] args){
        Integer a = 10;
        int b = a;

        List<Integer> integers = Arrays.asList(1, 2, 3);
        System.out.println(integers.stream().filter(g -> g == 1).collect(Collectors.toList()));

    }
}
