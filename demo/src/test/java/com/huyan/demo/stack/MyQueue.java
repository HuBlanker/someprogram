// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.stack;


import java.util.Stack;

public class MyQueue {

  private Stack<Integer> main = new Stack<>();
  private Stack<Integer> helper = new Stack<>();

  public MyQueue() {
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
    if (helper.empty()) {
      while (!main.empty()) {
        helper.push(main.pop());
      }
    }
    return helper.pop();
  }

  /*
   * @return: An integer
   */
  public int top() {
    // write your code here
    if (helper.empty()) {
      while (!main.empty()) {
        helper.push(main.pop());
      }
    }
    return helper.peek();
  }
}

