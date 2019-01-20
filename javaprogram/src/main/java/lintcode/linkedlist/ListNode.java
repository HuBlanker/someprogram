// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package lintcode.linkedlist;

/**
 * created by huyanshi on 2018/11/26
 */
public class ListNode {

  private int val;
  private ListNode next;


  ListNode(int x) {
    val = x;
    next = null;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    printLinkedList(node1);
    System.out.println("非递归翻转:");
    printLinkedList(reverse(node1));
    System.out.println("递归翻转:");
    printLinkedList(reverse2(node3, null));
  }


  /**
   * 非递归实现,直接传入当前节点即可
   */
  public static ListNode reverse(ListNode head) {
    // write your code here
    //初始化将前置及后继节点置为null
    ListNode nextNode = null;
    ListNode preNode = null;

    //当前节点不为空
    while (head != null) {
      //记录后继节点
      nextNode = head.next;
      //翻转,将当前节点的next指针指向前置节点
      head.next = preNode;
      //记录当前节点(即下一次循环时的前置节点)
      preNode = head;
      //向后遍历
      head = nextNode;
    }
    //为空时返回前置节点
    return preNode;
  }

  /**
   * 递归实现,将前置节点作为参数传递,初始调用pre=null
   */
  private static ListNode reverse2(ListNode head, ListNode pre) {
    // write your code here
    //如果当前节点为空,返回前置节点,这样可以再结束时拿到头结点
    if (head == null) {
      return pre;
    }
    //保存后继节点
    ListNode next = head.next;
    //将当前节点的next指针指向前置节点(翻转操作)
    head.next = pre;
    //翻转下一个节点及其前置节点
    return reverse2(next, head);
  }

  /**
   * 打印链表
   **/
  private static void printLinkedList(ListNode head) {
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val);
      System.out.print("->");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }

}
