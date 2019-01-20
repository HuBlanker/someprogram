// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

public class Test20181222 {


  @Test
  public void tets() {
    LocalDate ha = LocalDate.now().minusYears(18).minusMonths(10)
        .with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(ha);
  }

  public int singleNonDuplicate(int[] nums) {
    // write your code here
    int result = 0;
    for (int num : nums) {
      result = result ^ num;
    }
    return result;
  }

  public List<Integer> flatten1(List<NestedInteger> nestedList) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nestedList.size(); i++) {
      //是整数则添加到结果集
      if (nestedList.get(i).isInteger()) {
        result.add(nestedList.get(i).getInteger());
        continue;
      }
      //是列表则递归调用将结果全添加到结果集中
      result.addAll(flatten1(nestedList.get(i).getList()));
    }
    return result;
  }

  public List<Integer> flatten2(List<NestedInteger> nestedList) {
    List<Integer> result = new LinkedList<>();
    Stack<NestedInteger> stack = new Stack<>();
    //初始全部入栈
    nestedList.forEach((stack::push));
    while (!stack.isEmpty()) {
      NestedInteger current = stack.pop();
      if (current == null) {
        continue;
      }
      //当前为整数则添加到结果集
      if (current.isInteger()) {
        ((LinkedList<Integer>) result).addFirst(current.getInteger());
      } else {
        //否则遍历列表将元素全部入栈
        current.getList().forEach(stack::push);
      }
    }
    return result;
  }


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }


}
