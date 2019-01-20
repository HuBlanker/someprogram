package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public class InsertionSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {
    for (int i = 1; i < input.length; i++) {
      int j = i - 1;
      //拿到当前待插入的值
      int current = input[i];
      //从当前位置向前遍历,逐一比较
      while (j >= 0) {
        //如果当前值大于该位置的值
        if (current > input[j]) {
          //在该位置之后放入当前值,跳出循环
          input[j + 1] = current;
          break;
        } else {
          //将该位置的值后移一位
          input[j + 1] = input[j];
        }
        if (j == 0){
          //如果该位置为0,且大于当前值,则将当前值放在第一位
          input[j] = current;
        }
        j--;
      }

    }
    return input;
  }
}
