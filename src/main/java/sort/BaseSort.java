package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public abstract class BaseSort {

  public abstract int[] sort(int[] input);

  public void exchange(int[] input, int i, int j) {
    int tmp = input[i];
    input[i] = input[j];
    input[j] = tmp;
  }

}
