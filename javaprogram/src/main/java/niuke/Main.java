// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * created by pfliu on 2018/11/11
 */
public class Main {


  public static void main(String[] args) {

    int result = 0;

    Scanner sc = new Scanner(System.in);

    String line1 = sc.nextLine();
    String[] line1Arr = line1.split(" ");

    String line2 = sc.nextLine();
    String[] line2Arr = line2.split(" ");

    int columnNum = Integer.valueOf(line1Arr[0]);
    int m = Integer.valueOf(line1Arr[1]);

    Map<String, Integer> tmp = new HashMap<>();

    for (int i = 0; i < line2Arr.length; i++) {
      if (tmp.containsKey(line2Arr[i])) {
        tmp.put(line2Arr[i], tmp.get(line2Arr[i]) + 1);
      } else {
        tmp.put(line2Arr[i], 1);
      }
    }

    if (tmp.keySet().size() == columnNum) {
      result = tmp.values().stream().mapToInt(per -> {
        return per;
      }).min().getAsInt();

    } else {
      result = 0;
    }

    System.out.println(result);
  }
}


