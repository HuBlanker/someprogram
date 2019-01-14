package sort;

/**
 * created by huyanshi on 2019/1/14
 */
public class QuickSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {
    quickSort(input, 0, input.length - 1);
    return input;
  }

  private void quickSort(int[] a, int start, int end) {
    if (start < end) {
      //如果不止一个元素，继续划分两边递归排序下去
      int partition = partition(a, start, end);
      quickSort(a, start, partition - 1);
      quickSort(a, partition + 1, end);
    }
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

}
