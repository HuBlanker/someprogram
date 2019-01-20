// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * created by huyanshi on 2018/12/26
 */
public class Test20181227 {


  @Test
  public void test() {
    ListNode node = new ListNode(3);
    ListNode node1 = new ListNode(1);
    node.next = node1;
    ListNode node2 = new ListNode(5);
    node1.next = node2;
    int i = list2Int(node);


    ListNode node10 = new ListNode(5);
    ListNode node11 = new ListNode(9);
    node10.next = node11;
    ListNode node12 = new ListNode(2);
    node11.next = node12;
    int j = list2Int(node10);


    ListNode ha = addLists(new ListNode(0), new ListNode(0));

    int hehe = 0;

  }


  public ListNode addLists(ListNode l1, ListNode l2) {
    // write your code here
    if (l1 == null || (l1.val ==0 && l1.next == null)) {
      return l2;
    }
    if (l2 == null||(l2.val ==0 && l2.next == null)) {
      return l1;
    }
    return int2List(list2Int(l1) + list2Int(l2));

  }


  private int list2Int(ListNode root) {
    int result = root.val;
    int i =0;
    ListNode next;
    while ((next = root.next) != null) {
      result += next.val * Math.pow(10, ++i);
      root = root.next;

    }
    return result;
  }

  private ListNode int2List(int x) {
    List<Integer> tmp = new ArrayList<>();
    while (x != 0) {
      tmp.add(x % 10);
      x = x / 10;
    }

    List<ListNode> nodes = new ArrayList<>();
    for (Integer i : tmp) {
      nodes.add(new ListNode(i));
    }

    for (int i = 0; i < nodes.size() - 1; i++) {
      nodes.get(i).next = nodes.get(i + 1);
    }
    return nodes.get(0);
  }


  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
