package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public class BubbleSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {
    for (int i = 0; i < input.length - 1; i++) {
      for (int j = 0; j < input.length - i - 1; j++) {
        if (input[j] > input[j + 1]) {
          exchange(input, j, j + 1);
        }
      }
    }
    return input;
  }
}
