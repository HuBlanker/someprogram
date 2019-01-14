package sort;

/**
 * created by huyanshi on 2019/1/14
 */
public class HeapSort extends BaseSort {

  int len;


  @Override
  public int[] sort(int[] input) {

    len = input.length;
    if (len < 1) {
      return input;
    }
    //1.构建一个最大堆
    buildMaxHeap(input);
    //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
    while (len > 0) {
      exchange(input, 0, len - 1);
      len--;
      adjustHeap(input, 0);
    }
    return input;
  }


  /**
   * 建立最大堆
   */
  private void buildMaxHeap(int[] array) {
    //从最后一个非叶子节点开始向上构造最大堆
    for (int i = (len / 2 - 1); i >= 0; i--) {
      adjustHeap(array, i);
    }
  }

  /**
   * 调整使之成为最大堆
   */
  private void adjustHeap(int[] array, int i) {
    int maxIndex = i;
    //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (i * 2 < len && array[i * 2] > array[maxIndex]) {
      maxIndex = i * 2;
    }
    //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
    if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
      maxIndex = i * 2 + 1;
    }
    //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
    if (maxIndex != i) {
      exchange(array, maxIndex, i);
      adjustHeap(array, maxIndex);
    }
  }
}
