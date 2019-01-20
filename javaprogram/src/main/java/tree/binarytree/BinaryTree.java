// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package tree.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * created by pfliu on 2018/11/4
 */
public class BinaryTree {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
//    //递归前序遍历前序遍历
//    binaryTree.preOrderTraversal().forEach(System.out::println);
//    //非递归前序遍历
//    binaryTree.preOrderTraversal2().forEach(System.out::println);
//    //递归实现中序遍历
//    binaryTree.inOrderTraversal().forEach(System.out::println);
//    //非递归实现中序遍历
//    binaryTree.inOrderTraversal2().forEach(System.out::println);
//    //递归实现后续遍历
//    binaryTree.postOrderTraversal().forEach(System.out::println);
//    //非递归实现后续遍历
//    binaryTree.postOrderTraversal2().forEach(System.out::println);
    //层次遍历
    binaryTree.levelIterator().forEach(System.out::println);
  }

  private Node root;

  private BinaryTree() {
    root = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)),
        new Node(3, null, new Node(6, null, null)));
  }


  class Node {

    int val;
    //左孩子
    Node left;
    //右孩子
    Node right;

    Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return String.valueOf(val);
    }
  }


  /**
   * 前序遍历(递归)： 1、访问这个节点 2、调用自身来遍历节点的左子树 3、调用自身来遍历节点的右子树
   */
  private List<Integer> preOrderTraversal() {
    List<Integer> result = new ArrayList<>();
    preOrder(root, result);
    return result;

  }

  private void preOrder(Node root, List<Integer> result) {
    if (null == root) {
      return;
    }
    result.add(root.val);
    preOrder(root.left, result);
    preOrder(root.right, result);
  }

  /**
   * 非递归先序遍历二叉树
   */
  private List<Integer> preOrderTraversal2() {
    List<Integer> resultList = new ArrayList<>();
    Stack<Node> treeStack = new Stack<>();
    if (root == null) //如果为空树则返回
    {
      return resultList;
    }
    treeStack.push(root);
    while (!treeStack.isEmpty()) {
      Node tempNode = treeStack.pop();
      if (tempNode != null) {
        resultList.add(tempNode.val);//访问根节点
        treeStack.push(tempNode.right); //入栈右孩子
        treeStack.push(tempNode.left);//入栈左孩子
      }
    }
    return resultList;
  }

  /**
   * 递归实现中序遍历
   */
  private List<Integer> inOrderTraversal() {
    List<Integer> result = new ArrayList<>();
    inOrder(root, result);
    return result;
  }

  private void inOrder(Node root, List<Integer> result) {
    if (null == root) {
      return;
    }
    inOrder(root.left, result);
    result.add(root.val);
    inOrder(root.right, result);
  }

  /**
   * 非递归实现中序遍历
   */
  private List<Integer> inOrderTraversal2() {
    List<Integer> list = new ArrayList<>();

    Stack<Node> stack = new Stack<>();
    Node cur = root;

    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.add(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
    }
    return list;
  }


  /**
   * 递归实现后序遍历
   */
  private List<Integer> postOrderTraversal() {
    List<Integer> result = new ArrayList<>();
    postOrder(root, result);
    return result;
  }

  private void postOrder(Node root, List<Integer> result) {
    if (null == root) {
      return;
    }
    postOrder(root.left, result);
    postOrder(root.right, result);
    result.add(root.val);
  }

  /**
   * 非递归实现后序遍历
   */
  private List<Integer> postOrderTraversal2() {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    List<Integer> resultList = new ArrayList<>();
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node != null) {
        resultList.add(node.val);
        stack.push(node.left);
        stack.push(node.right);
      }
    }
    Collections.reverse(resultList);
    return resultList;
  }

  /**
   * 层次遍历
   */
  private List<Integer> levelIterator() {
    List<Integer> resultList = new ArrayList<>();
    if (root == null) {
      return resultList;
    }
    LinkedList<Node> queue = new LinkedList<Node>();
    Node current = null;
    queue.offer(root);//将根节点入队
    while (!queue.isEmpty()) {
        current = queue.poll();//出队队头元素并访问
      if (current != null) {
        resultList.add(current.val);
        queue.offer(current.left);
        queue.offer(current.right);
      }
    }
    return resultList;
  }

}
