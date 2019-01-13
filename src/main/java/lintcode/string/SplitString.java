// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package lintcode.string;

import java.util.Stack;

/**
 * created by huyanshi on 2018/11/27
 */
public class SplitString {

  public static void main(String[] args) {
    System.out.println(getAns("aabbcc", 2));
  }


  /**
   * 最少划分子串
   */
  public static int getAns(String s, int k) {
    // Write your code here
    //空栈
    Stack<Character> tmp = new Stack<>();
    //结果
    int result = 0;

    for (int i = 0; i < s.length(); ) {
      //拿到当前字符
      Character current = s.charAt(i);

      //如果栈不为空
      if (tmp.size() > 0) {
        //如果栈里的字符数量大于k,或者当前字符与栈顶元素不同,清空栈,结果+1,然后跳过后续代码继续循环
        if (tmp.size() >= k || !tmp.peek().equals(current)) {
          tmp.clear();
          result++;
          continue;
        }
      }
      //如果栈为空,和不满足上述两个条件的,将当前元素入栈,继续向后遍历下一个字符
      tmp.push(current);
      i++;
    }
    //由于最后一个子串跳出循环时,没有进行result+1操作,这里补上.
    return result + 1;
  }

}
