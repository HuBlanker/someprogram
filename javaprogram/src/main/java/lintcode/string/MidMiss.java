package lintcode.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * created by huyanshi on 2019/1/22
 */
public class MidMiss {


  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    if (nums.length == 0) {
      return null;
    }
    // write your code here
    List<Integer> list = new ArrayList<>();
    for (int i : nums) {
      if (i >= lower && i < upper) {
        list.add(i);
      }
    }

    Map<Integer, Integer> range = new LinkedHashMap<>();

    if (lower < list.get(0)) {
      range.put(lower, list.get(0));

    }
    for (int i = 0; i < list.size() - 1; i++) {
      range.put(list.get(i), list.get(i + 1));
    }

    if (upper > list.get(list.size() - 1)) {
      range.put(list.get(list.size() - 1), upper);

    }

    List<String> result = new ArrayList<>();
    range.entrySet().stream().forEach(per -> {
      switch (per.getValue() - per.getKey()) {
        case 0:
        case 1:
          break;
        case 2:
          result.add(String.valueOf(per.getValue() - 1));
          break;
        default:
          result.add((per.getKey() + 1) + "->" + (per.getValue() - 1));
      }
    });

    return result;

  }

  public static void main(String[] args) {
    MidMiss midMiss = new MidMiss();

    int[] nums = new int[]{0, 1, 3, 50, 75};
    List<String> result = midMiss.findMissingRanges(nums, 0, 99);
    System.out.println(result);
  }

}
