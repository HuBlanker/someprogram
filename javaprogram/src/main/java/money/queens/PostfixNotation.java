package money.queens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  use a stack solve the postfix notation.
 */
public class PostfixNotation {

  static char[] op = {'+', '-', '*', '/', '(', ')'};

  private static String transfer(String s) {

    char[] ss = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < ss.length; i++) {
      // ignore space
      if (ss[i] == ' ') {
        continue;
      }
      // char is a number
      if (ss[i] > 47 && ss[i] < 58) {
        sb.append(ss[i]).append(" ");
      }
      //is a op
      if (isOp(ss[i])) {
        // if stack is empty , push it
        if (stack.empty()) {
          stack.push(ss[i]);
        } else {
          // current op type
          int current = getType(ss[i]);
          //if op is + or -
          if (current == 1) {
            while (!stack.isEmpty() && getType(stack.peek()) != 3) {
              sb.append(stack.pop()).append(" ");
            }
            if (stack.empty() || getType(stack.peek()) == 3) {
              stack.push(ss[i]);
            }
          }
          // if op is  * or /
          if (current == 2) {
            while (getType(stack.peek()) == 2) {
              sb.append(stack.pop());
            }
            if (stack.isEmpty() || getType(stack.peek()) == 3 || getType(stack.peek()) == 1) {
              stack.push(ss[i]);
            }
          }
          // if op is (
          if (current == 3) {
            stack.push(ss[i]);
          }
          // if op is )
          if (current == 4) {
            while (getType(stack.peek()) != 3) {
              sb.append(stack.pop()).append(" ");
            }
            if (getType(stack.peek()) == 3) {
              stack.pop();
            }
          }


        }
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    return sb.toString();
  }

  /**
   * judge a char is a op or not
   */
  private static boolean isOp(char c) {
    for (int i = 0; i < op.length; i++) {
      if (c == op[i]) {
        return true;
      }
    }
    return false;
  }

  /**
   * get type of op, + - is 1, * / is 2, (is three, ) is 4
   */
  private static int getType(char c) {
    if (c == '+' || c == '-') {
      return 1;
    }
    if (c == '*' || c == '/') {
      return 2;
    }
    if (c == '(') {
      return 3;
    }
    if (c == ')') {
      return 4;
    }
    return 0;
  }

  //main method, include some test cases
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new File("/input.txt"));
    String input = scanner.nextLine();

    BufferedWriter outputStream = new BufferedWriter(new FileWriter(new File("./output.txt")));
    outputStream.write(transfer(input));
    outputStream.flush();
    outputStream.close();
  }


}
