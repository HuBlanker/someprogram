package sort;

import heap.MinHeap;

/**
 * created by huyanshi on 2019/1/16
 */
public class TopKProblem {

  public static void main(String[] args) {
    TopKProblem tk = new TopKProblem();
    int k = 3;
    int array[] = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
    int index = tk.findTopK1(array, 0, array.length - 1, k);
    System.out.println("使用快速选择:");
    for (int i = 0; i <= index; i++) {
      System.out.print(array[i] + ",");
    }
    System.out.println();

    int k1 = 3;
    int array1[] = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
    int index1 = tk.findTopK2(array1, k1);
    System.out.println("使用堆:");
    for (int i = 0; i <= index1; i++) {
      System.out.print(array[i] + ",");
    }

  }


  /**
   * 找到前k大的元素,返回的index为第k大元素的下标,遍历0-index即可
   */
  private int findTopK1(int[] arr, int start, int end, int k) {
    int index = -1;
    if (start < end) {
      //切分,找到标志位的下标
      int mid = partition(arr, start, end);
      //计算左边数组长度
      int leftLen = mid - start + 1;
      //如果左边长度=k,则直接返回
      if (leftLen == k) {
        index = mid;
        //左边长度大于k,在左边数组寻找前k大元素
      } else if (leftLen > k) {
        index = findTopK1(arr, start, mid, k);
        //左边长度小于k,在右边数组寻找前k-len个元素.
      } else {
        index = findTopK1(arr, mid + 1, end, k - leftLen);
      }
      //返回第k大元素的下标.
      return index;
    }
    return index;
  }


  public int partition(int[] a, int start, int end) {
    //以最左边的值为基准
    int base = a[start];
    //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
    while (start < end) {
      while (start < end && a[end] >= base) {
        //从右边开始遍历，如果比基准值大，就继续向左走
        end--;
      }
      //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
      if (start < end) {
        //交换
        exchange(a, start, end);
        //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
        start++;
      }
      while (start < end && a[start] <= base) {
        //从左边开始遍历，如果比基准值小，就继续向右走
        start++;
      }
      //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
      if (start < end) {
        //交换
        exchange(a, start, end);
        //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
        end--;
      }
    }
    //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
    return end;
  }

  public void exchange(int[] input, int i, int j) {
    int tmp = input[i];
    input[i] = input[j];
    input[j] = tmp;
  }


  /**
   * 使用最小堆求TOP-K问题
   */
  private int findTopK2(int[] arr, int k) {
    //最小堆
    MinHeap heap = new MinHeap();
    //建堆
    heap.buildMaxHeap(arr, arr.length);
    for (int i = k; i < arr.length; i++) {
      //如果当前值大于堆顶元素,则替换掉堆顶元素并调整堆
      if (arr[i] > arr[0]) {
        arr[0] = arr[i];
        heap.delete(arr, k);
      }
    }
    //这里其实不需要返回值,只是因为在findTopK1中返回了index,这里也返回index,方便遍历
    //其实在此方法执行后,arr数组的钱K位就是所求元素,直接遍历即可
    return k - 1;
  }


}
