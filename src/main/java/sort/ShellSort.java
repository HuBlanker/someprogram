package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public class ShellSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {

    //初始步长
    int d = input.length / 2;

    //当步长大于等于1,保证最后作为一个数组排序过
    while (d >= 1) {
      //对每一种步长,遍历所有(步长为5,遍历1到5,即可遍历所有)
      for (int i = 0; i < d; i++) {
        //插入排序,普通插入排序每次递增1,这里递增步长d
        for (int j = i + d; j < input.length; j += d) {
          int tmp = input[j];
          int p;
          for (p = j - d; p >= 0 && input[p] > tmp; p -= d) {
            input[p + d] = input[p];
          }
          input[p + d] = tmp;
        }
      }
      //步长减半
      d=d/2;
    }
    return input;
  }
}
