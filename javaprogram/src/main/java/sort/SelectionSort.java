package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public class SelectionSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {

    int minIndex = 0;
    for (int i = 0; i < input.length; i++) {
      minIndex = i; // 将当前位置作为最小值得下标
      for (int j = i; j < input.length; j++) {
        if (input[minIndex] > input[j]) {
          //如果发现比最小下标的值还小的位置,替换最小下标
          minIndex = j;
        }
      }
      //将当前位置和最小下标位置的值交换
      exchange(input, minIndex, i);
    }
    return input;
  }
}
