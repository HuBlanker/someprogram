package sort;

import java.util.Arrays;

/**
 * created by huyanshi on 2019/1/14
 */
public class MergerSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {
    //当长度小于2,返回
    if (input.length < 2) {
      return input;
    }
    //分隔成左右两部分
    int mid = input.length / 2;
    int[] left = Arrays.copyOfRange(input, 0, mid);
    int[] right = Arrays.copyOfRange(input, mid, input.length);

    //分别进行归并排序并merge结果
    return merge(sort(left), sort(right));

  }

  public int[] merge(int[] A, int[] B) {
    //定义新数组,长度等于两个数组织和
    int[] result = new int[A.length + B.length];
    //定义三个指针,指向两个输入数组和结果数组
    int i = 0, j = 0, h = 0;
    //当A,B都没有遍历完的时候
    while (i < A.length && j < B.length) {
      //取较小的一个加入结果数组,然后将该数组的指针后移,结果数组指针后移
      if (A[i] <= B[j]) {
        result[h] = A[i];
        i++;
      } else {
        result[h] = B[j];
        j++;
      }
      h++;
    }
    //分别遍历两个数组,将剩余数字加入结果数组中.
    //这里其实只会执行一个,因为从while循环中出来,必然有一个数组被遍历完了.
    for (; i < A.length; i++, h++) {
      result[h] = A[i];
    }
    for (; j < B.length; j++, h++) {
      result[h] = B[j];
    }
    //返回结果
    return result;
  }
}
