// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo;

import com.huyan.demo.controller.TTTController;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by huyanshi on 2018/12/27
 */
@Component
public class TTTTest {

  @Autowired
  private TTTController controller;


  @Test
  public void ha() {
    int[][] heihei = spiralArray(3);
    int i = 0;

  }

  public boolean isValidTriangle(int a, int b, int c) {
    // write your code here
    if (a - b - c >= 0) {
      return false;
    }
    if (b - a - c >= 0) {
      return false;
    }
    if (c - a - b >= 0) {
      return false;
    }
    return true;
  }


  public int[][] spiralArray(int n) {
    int[][] res = new int[n][n];
    //定义每一步的x,y轴增量,顺序为右下左上,比如:当向右走的时候,x坐标不变,y坐标每次加1.
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    //x,y作为当前的下标
    //d为方向

    //i,y遍历用
    //nx,ny,下一个的x,y坐标

    int x, y, d;
    int i, j, nx, ny;
    // 将二维数组全部初始化为-1,-1用来判断当前位置是否已经走过
    for (i = 0; i < n; ++i) {
      for (j = 0; j < n; ++j) {
        res[i][j] = -1;
      }
    }

    x = 0;
    y = 0;
    d = 0;
    //i在这个时候相当于每个位置应该放的数字
    for (i = 1; i <= n * n; ++i) {
      //当前位置放置i
      res[x][y] = i;
      //计算下一个的x,y坐标.  计算方法为:x+增量,增量由当前的方向决定
      nx = x + dx[d];
      ny = y + dy[d];

      //判断下一步的x,y坐标是否有问题,包括:四种越界和该位置已经走过了
      if (nx < 0 || nx >= n || ny < 0 || ny >= n || res[nx][ny] != -1) {
        //如果下一步有问题,转向,转向方法为:(d+1)%4,这样可以按照右下左上的顺序来旋转
        d = (d + 1) % 4;
        //方向改变,增量改变,重新计算新的下一步坐标
        nx = x + dx[d];
        ny = y + dy[d];
      }
      //走下一步
      x = nx;
      y = ny;
    }
    //返回.
    return res;
  }

  @Test
  public void ha1() {

    StringBuilder sb = new StringBuilder();
    sb.append("yyyy年MM月dd日 HH\''mm\''ss");
    SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());
    String dateString = sdf.format(new Date());
    System.out.println(dateString);


  }

  public String radarDetection(Point[] coordinates, int[] radius) {
    // Write your code here
    for (int i = 0; i < coordinates.length; i++) {
      if (Math.abs(coordinates[i].y) - radius[i] <= 0) {
        return "YES";
      }
    }
    return "NO";
  }


  class Point {

    int x;
    int y;

    Point() {
      x = 0;
      y = 0;
    }

    Point(int a, int b) {
      x = a;
      y = b;
    }
  }


  public ListNode deleteDuplicates(ListNode head) {
    //头结点不会变化,所有提前记录以便防具
    ListNode node = head;
    //当前指针为空或者像一个节点为空,结束
    while (head != null && head.next != null) {
      //如果当前节点的值等于下一个节点的值,则跳过下一个节点
      if (head.val == head.next.val) {
        head.next = head.next.next;
      } else {
        //不相等的话讲当前指针后移一位
        head = head.next;
      }
    }
    //返回初始记录的头结点.
    return node;
  }


  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //由于不知道两个链表哪个头结点大,所以自定义一个头结点
    ListNode dummy = new ListNode(-1), cur = dummy;
    //当两个链表都不为空
    while (l1 != null && l2 != null) {
      //将两个链表中较小的当前节点链接在结果链表上,该链表后移一位
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      //结果链表也后移一位
      cur = cur.next;
    }
    //当其中一个为空时,将另一个链表剩余所有值链接在结果链表上
    cur.next = (l1 != null) ? l1 : l2;
    //返回自定义的头结点的下一个节点
    return dummy.next;
  }

  @Test
  public void jj() {
    int[] ha = new int[]{1, 2, 3, 4};
    int[] ha1 = new int[]{2, 4, 5, 6};
    mergeSortedArray(ha, ha1);
  }

  public int[] mergeSortedArray(int[] A, int[] B) {
    //定义新数组,长度等于两个数组织和
    int[] result = new int[A.length + B.length];
    //定义三个指针,指向两个输入数组和结果数组
    int i = 0, j = 0, h = 0;
    //当A,B都没有遍历完的时候
    while (i < A.length && j < B.length) {
      //取较小的一个加入结果数组,然后将该数组的指针后移,结果数组指针后移
      if (A[i] <= B[j]) {
        result[h] = A[i];
        i++;
      } else {
        result[h] = B[j];
        j++;
      }
      h++;
    }
    //分别遍历两个数组,将剩余数字加入结果数组中.
    //这里其实只会执行一个,因为从while循环中出来,必然有一个数组被遍历完了.
    for (; i < A.length; i++,h++) {
      result[h] = A[i];
    }
    for (; j < B.length; j++,h++) {
      result[h] = B[j];
    }
    //返回结果
    return result;
  }


}
