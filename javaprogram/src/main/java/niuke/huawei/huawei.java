package niuke.huawei;

import java.util.Scanner;

/**
 * created by huyanshi on 2019/2/24
 */
public class huawei {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine().toLowerCase();
    System.out.println(s);

    char c = sc.nextLine().toCharArray()[0];

    char[] arr = s.toCharArray();

    int num = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == c) {
        num++;
      }
    }
    System.out.println(num);

  }
}
