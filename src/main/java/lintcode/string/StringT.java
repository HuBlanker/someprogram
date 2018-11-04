// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package lintcode.string;

/**
 * created by pfliu on 2018/10/12
 */
public class StringT {

  public static void main(String [] args) {
    System.out.println(reverseWords("world"));
  }


  public static String reverseWords(String s) {
    if (s == null) {
      return null;
    }
    if ("".equals(s)){
      return "";
    }
    String[] ss = s.split(" ");
    String[] result = new String[ss.length];
    int j = 0;
    for (String s1 : ss) {
      if (null != s1 && !"".equals(s1)) {
        result[j] = s1;
        j++;
      }
    }
    StringBuilder ha = new StringBuilder();
    for (int i = result.length - 1; i >= 0; i--) {
      ha.append(result[i]);
      if (i != 0) {
        ha.append(" ");
      }

    }
    return ha.toString();

  }

}
