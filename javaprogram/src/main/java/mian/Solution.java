package mian;

/**
 * created by huyanshi on 2019/2/28
 */
class Solution {

  int solution(int[] A) {
    if (A.length < 1) {
      return 0;
    }

    int one = A[0];
    int oneIndex = 0;
    int two = A[0];
    int twoIndex = 0;

    for (int i = 0; i < A.length; i++) {
      int now = one + two + Math.abs(oneIndex - twoIndex);
      int tmpOne = A[i] + two + Math.abs(twoIndex - i);
      if (tmpOne > now) {
        one = A[i];
        oneIndex = i;
      }
      int now1 = one + two + Math.abs(oneIndex - twoIndex);

      int tmpTwo = A[i] + one + Math.abs(oneIndex - i);
      if (tmpTwo > now1) {
        two = A[i];
        twoIndex = i;
      }
    }

    return one + two + Math.abs(oneIndex - twoIndex);

  }

  int solution(int[] A, int X, int Y, int Z) {

    int now[] = {X, Y, Z};

    int maxTime = 0;
    int time[] = {0, 0, 0};
    for (int i = 0; i < A.length; i++) {
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      boolean flag = false;
      for (int j = 0; j < 3; j++) {
        if (now[j] >= A[i]) {
          flag = true;
          if (min > time[j] + A[j]) {
            min = time[j] + A[j];
            minIndex = j;
          }
        }
      }
      if (!flag) {
        return -1;
      }
      if (minIndex == -1) {
        return -1;
      }
      time[minIndex] = time[minIndex] + A[i];
      now[minIndex] = now[minIndex] - A[i];

    }
    for (int i = 0; i < time.length; i++) {
      if (maxTime < time[i]) {
        maxTime = time[i];
      }
    }
    return maxTime - A[A.length-1];

  }

  public static void main(String[] args) {
//    int[] arr = {-8, 4, 0, 5, -3, 6};
//    int[] arr1 = {1, 3, -3};
//
//    System.out.println(new Solution().solution(arr));
//
//    System.out.println(new Solution().solution(arr1));
    int arr[] = {2, 8, 4, 3, 2};
    System.out.println(new Solution().solution(arr, 7, 11, 3));
    int arr1[] = {5};
    System.out.println(new Solution().solution(arr1, 4, 0, 3));

  }
}