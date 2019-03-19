package mian;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12,
        7, 8, 9, 11, 11, 12, 2, 11, 4, 4};

    if (arr == null) {
      return;
    }
    List<Integer> distinctList = Stream.of(arr).distinct().collect(Collectors.toList());
    if (distinctList.size() < 11) {
      return;
    }

    //求第十一大的数字
    Integer top11 = getTop(distinctList, 11);
    System.out.println(top11);

    //求中位数
    List<Integer> filtered = Stream.of(arr).filter(i -> i <= top11).sorted(
        Comparator.comparingInt(o -> o)).collect(Collectors.toList());
    double mid = getMid(filtered);
    System.out.println(mid);
  }

  /**
   * 获取第target大的数,使用最小堆
   */
  private static Integer getTop(List<Integer> input, int target) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(input.subList(0, target));
    for (int j = target; j < input.size(); j++) {
      //如果新元素小于堆顶,丢弃,如果大于,替换堆顶元素
      if (input.get(j) < heap.peek()) {
        continue;
      }
      heap.poll();
      heap.add(input.get(j));
    }
    return heap.poll();
  }

  /**
   * 获取中位数
   */
  private static double getMid(List<Integer> input) {
    int size = input.size();
    //根据数组的长度是否为奇数决定返回值
    return size % 2 == 1 ? input.get(size / 2)
        : (input.get(size / 2) + input.get(size / 2 - 1)) / 2;
  }
}
