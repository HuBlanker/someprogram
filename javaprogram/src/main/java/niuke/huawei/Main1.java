package niuke.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * created by huyanshi on 2019/2/24
 */
public class Main1 {

//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    List<Set<Integer>> l = new ArrayList<>();
//    while (sc.hasNextInt()) {
//      int n = sc.nextInt();
//      Set<Integer> set = new HashSet<>();
//      for (int i = 0; i < n; i++) {
//        set.add(sc.nextInt());
//      }
//      l.add(set);
//    }
//    sc.close();
//
//    l.forEach(set -> {
//      set.stream().sorted((o1, o2) -> {
//        return o1 - o2;
//      }).forEach(System.out::println);
//    });
//
//    StringBuilder sb = new StringBuilder()
//
//  }

  public static void main(String [] args){
    List<String> s = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
      s.add(sc.nextLine());
    }

    for(int i =0;i < s.size();i++){
      System.out.println(transfer(s.get(i)));
    }

  }

  private static String transfer(String s){
    s = s.replace("0x","");
    int result = 0;
    char [] arr = s.toCharArray();
    int l = 0;
    for(int i = arr.length - 1; i >=0 && l < arr.length;i --){
      int k = getInt(arr[i]);
      result += k * Math.pow(16,l);
      l++;
    }
    return String.valueOf(result);
  }

  private static Integer getInt(char c){
    switch(c){
      case 'A':
        return 10;
      case 'B':
        return 11;
      case 'C':
        return 12;
      case 'D':
        return 13;
      case 'E':
        return 14;
      case 'F':
        return 15;
      default:
        return (int) c -37;
    }
  }
}
