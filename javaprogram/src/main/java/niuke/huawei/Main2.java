package niuke.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main2 {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();

    char[] cArr = String.valueOf(s).toCharArray();

    List<Character> list = new ArrayList<>();

    for (int i = 0; i < cArr.length; i++) {
      list.add(cArr[i]);
    }

    for (int i = 0; i < list.size(); i++) {
      char c = list.get(i);
      for (int j = 0; j < i; j++) {
        if (list.get(j) == list.get(i)) {
          if (list.get(j + 1) > list.get(i)) {
            list.remove(j);
          }else {
            list.remove(i);
          }
          i--;
        }
      }
    }

    list.forEach(System.out::print);

  }

}
