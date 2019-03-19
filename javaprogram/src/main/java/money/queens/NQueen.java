package money.queens;

import java.util.Arrays;

/**
 * solve the N-Queen problem
 */
public class NQueen {

  //the number of chess board,example 8
  private static final int N = 8;

  // result, the result[i] mean: the location of [i] line is on result[i] column.
  private int[] result = new int[N];

  //total num of possible result
  private int resultNum = 0;

  /**
   * calculation
   */
  private void calculation(int n) {

    //if n == N, print the result
    if (n == N) {
      for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + ",");
      }
      System.out.println();
      resultNum++;
    } else {
      for (int i = 0; i < N; i++) {
        // test every location possible
        result[n] = i;
        //if line n is allowed, locate the next line
        if (isAllowed(n)) {
          calculation(n + 1);
        }
      }
    }
  }

  /**
   * judge current line is allowed or not.
   */
  private boolean isAllowed(int i) {
    // i is not allowed while it in same line or diagonal with the pre line
    for (int j = 0; j < i; j++) {
      if (result[i] == result[j] || Math.abs(i - j) == Math.abs(result[i] - result[j])) {
        return false;
      }
    }
    return true;
  }

  //main method, include some test cases
  public static void main(String[] args) {
    NQueen queen = new NQueen();

    queen.calculation(0);

    System.out.println(queen.resultNum);
  }

}
