package daily;

import util.Ticker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by pfliu on 2019/05/21.
 */
class Ideone {
    public static void main(String[] args) throws java.lang.Exception {

        List<Integer> is = new ArrayList<>();
        is.add(10);
        is.add(110);
        is.add(1);
        is.add(102);

        is.sort(Comparator.comparingInt(o -> o));
        System.out.println(is);

        System.out.println("===============");
        System.out.println(1 << 2);
        System.out.println("===============");


        Random r = new Random(System.currentTimeMillis());
        int i = 10;
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(r.nextInt(2));
        }


    }

    public String maximumm(List<Integer> numbers, String sss) {
        int toIndex = 3, fromIndex = 0;
        List<Integer> result = new ArrayList<>();
        while (toIndex < numbers.size()) {
            Map<Integer, Integer> map =
                    IntStream.range(fromIndex, toIndex).mapToObj(i -> new AbstractMap.SimpleEntry<>(i, numbers.get(i)))
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
            // find max of sublist
            int maxOfSub = numbers.subList(fromIndex, toIndex).stream().max(Integer::compareTo).get();
            //update indexes
            fromIndex = map.get(maxOfSub) + 2;
            toIndex += fromIndex;

            result.add(maxOfSub);
            Ticker ticker = new Ticker();

        }
        int lastMax = numbers.subList(fromIndex, numbers.size()).stream().max(Integer::compareTo).get();
        if (lastMax > 0) {
            result.add(lastMax);
        }
        result = result.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        //System.out.println(result);
        sss = sss.concat(result.toString().replace(", ", "").replace("]", "").replace("[", ""));
        return sss;
        //  return result.stream().reduce(0,Integer::sum);
    }
}

class H {

    public static void main(String[] args) {
        System.out.println(String.format("wode %s, 90%%!","zz"));
    }


    private int getTN(int now) {
        return Period.between(LocalDate.now().minusDays(3), LocalDate.now()).getDays();
    }
}
