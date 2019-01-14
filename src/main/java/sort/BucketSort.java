package sort;

/**
 * created by huyanshi on 2019/1/14
 */
public class BucketSort extends BaseSort {

  @Override
  public int[] sort(int[] input) {
    //分桶，这里采用映射函数f(x)=x/10。
    //输入数据为0~99之间的数字
    int bucketCount =10;
    Integer[][] bucket = new Integer[bucketCount][input.length];  //Integer初始为null,以与数字0区别。
    for (int i=0; i<input.length; i++){
      int quotient = input[i]/10;   //这里即是使用f(x)
      for (int j=0; j<input.length; j++){
        if (bucket[quotient][j]==null){
          bucket[quotient][j]=input[i];
          break;
        }
      }
    }
    //小桶排序
    for (int i=0; i<bucket.length; i++){
      //insertion sort
      for (int j=1; j<bucket[i].length; ++j){
        if(bucket[i][j]==null){
          break;
        }
        int value = bucket[i][j];
        int position=j;
        while (position>0 && bucket[i][position-1]>value){
          bucket[i][position] = bucket[i][position-1];
          position--;
        }
        bucket[i][position] = value;
      }

    }
    //输出
    for (int i=0, index=0; i<bucket.length; i++){
      for (int j=0; j<bucket[i].length; j++){
        if (bucket[i][j]!=null){
          input[index] = bucket[i][j];
          index++;
        }
        else{
          break;
        }
      }
    }
    return input;
  }
}
