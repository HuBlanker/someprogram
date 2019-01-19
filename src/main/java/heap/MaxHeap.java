package heap;

import java.util.Arrays;

/**
 * created by huyanshi on 2019/1/16
 */
public class MaxHeap {


  public static void main(String[] args) {

    MaxHeap heap = new MaxHeap();

    int[] data = {15, 13, 1, 5, 20, 12, 8, 9, 11};
    // 测试建堆
    heap.buildMaxHeap(data, data.length);
    System.out.println(Arrays.toString(data));

    // 测试插入
    int[] newArr = heap.insert(data, 14, data.length);
    System.out.println(Arrays.toString(newArr));

    // 测试删除
    heap.delete(newArr, data.length + 1);
    System.out.println(Arrays.toString(newArr));
  }

  /**
   * 建立最大堆
   */
  private void buildMaxHeap(int[] array, int len) {
    //从最后一个非叶子节点开始,逐个节点向前进行下沉
    for (int i = (len / 2 - 1); i >= 0; i--) {
      down(array, len, i);
    }
  }

  /**
   * 插入元素
   */
  private int[] insert(int[] array, int a, int len) {
    //copy到新数组,长度加1,并将添加的值放入末尾
    int[] newArr = Arrays.copyOf(array, len + 1);
    newArr[len] = a;
    //对新加入的值进行上浮
    return up(newArr, len + 1, len);
  }

  /**
   * 删除元素
   */
  private void delete(int[] array, int len) {
    //交换第一个和最后一个节点
    exchange(array, 0, len - 1);
    //从根节点进行下沉
    down(array, len - 1, 0);
  }

  /**
   * 元素下沉
   */
  private void down(int[] array, int len, int i) {
    int maxIndex = i;
    //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
      maxIndex = i * 2 + 1;
    }
    //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
    if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex]) {
      maxIndex = i * 2 + 2;
    }
    //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
    if (maxIndex != i) {
      exchange(array, maxIndex, i);
      down(array, len, maxIndex);
    }
  }


  /**
   * 元素上浮
   */
  private int[] up(int[] array, int len, int i) {
    //如果上浮到根节点了,则结束
    if (i == 0) {
      return array;
    }
    //如果当前节点大于其父节点,则交换值,并且对其父节点进行上浮.
    if (array[i] > array[(i - 1) / 2]) {
      exchange(array, i, (i - 1) / 2);
      array = up(array, len, (i - 1) / 2);
    }
    return array;
  }

  /**
   * 交换数组在两个下标的值
   */
  private void exchange(int[] input, int i, int j) {
    int tmp = input[i];
    input[i] = input[j];
    input[j] = tmp;
  }

}
