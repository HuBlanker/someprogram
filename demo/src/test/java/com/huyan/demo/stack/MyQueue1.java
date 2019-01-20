// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.stack;

import java.util.Stack;

public class MyQueue1 {

  private Stack<Integer> main = new Stack<>();
  private Stack<Integer> helper = new Stack<>();

  public MyQueue1() {
    // do intialization if necessary
  }

  /*
   * @param element: An integer
   * @return: nothing
   */
  public void push(int element) {
    // write your code here
    main.push(element);
  }

  /*
   * @return: An integer
   */
  public int pop() {
    // write your code here
    while (!main.empty()) {
      helper.push(main.pop());
    }
    int result = helper.pop();
    while (!helper.empty()) {
      main.push(helper.pop());
    }
    return result;
  }

  /*
   * @return: An integer
   */
  public int top() {
    // write your code here
    while (!main.empty()) {
      helper.push(main.pop());
    }
    int result = helper.peek();
    while (!helper.empty()) {
      main.push(helper.pop());
    }
    return result;
  }
}
