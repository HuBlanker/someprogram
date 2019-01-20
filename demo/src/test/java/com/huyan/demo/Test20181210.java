// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by huyanshi on 2018/12/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test20181210 {

  private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

  @Test
  public void t1() {

    String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

    List<String> result = generatePalindromes(s);

    result.forEach(System.out::println);

  }


  /**
   * 回文排列2
   */
  public List<String> generatePalindromes(String s) {
    //处理空字符串
    if (s.equals("")) {
      List<String> r = new ArrayList<>();
      r.add("");
      return r;
    }

    //获取给定字符串中每个字符的数量
    Map<Character, Integer> charNum = canPermutePalindrome(s);
    //如果不能形成回文序列,直接返回空列表
    if (null == charNum || charNum.keySet().size() == 0
        || charNum.values().stream().filter(per -> per % 2 != 0).count() > 1) {
      return new ArrayList<>();
    }

    //从map中获取要进行全排列的字符串
    List<Character> chars = new ArrayList<>();
    charNum.entrySet().forEach(entry -> {
      int num = entry.getValue();
      //考虑到共有5个a的情况,应该拿2个a来进行全排列
      while (num > 1) {
        chars.add(entry.getKey());
        num = num - 2;
      }
    });
    StringBuilder builder = new StringBuilder();
    chars.forEach(builder::append);

    //全排列的结果并进行去重
    Set<String> result = new HashSet<>(quanpailie(builder.toString().toCharArray(), 0));

    //获取可能存在可能不存在的中间值
    Optional<Character> meduim = charNum.entrySet().stream().filter(per -> per.getValue() % 2 != 0)
        .map(Entry::getKey).findFirst();

    String c = meduim.map(Object::toString).orElse("");

    //获取每一个结果
    List<String> r = new ArrayList<>();
    result.forEach(per -> {
      StringBuilder builder1 = new StringBuilder();
      builder1.append(per).append(c);
      for (int i = per.length() - 1; i >= 0; i--) {
        builder1.append(per.charAt(i));
      }
      r.add(builder1.toString());
    });
    return r;
  }

  /**
   * 全排列递归实现
   */
  private List<String> quanpailie(char[] cs, int current) {
    //结果
    List<String> result = new LinkedList<>();
    //当前指向数组最后一位时,将数组(全排列的一种)输出到结果集里
    if (current == cs.length - 1) {
      result.add(new String(cs));
    } else {
      //循环改变数组的第一个位置的值,并求剩下的其他字符的全排列,并装入结果集.
      for (int i = current; i < cs.length; i++) {
        //交换当前字符与下一字符
        swap(cs, current, i);
        //这一块难理解,相当于,在A确定放在第一位的时候,求BC的全排列,并且加上A,形成ABC,ACB放入结果集.
        result.addAll(quanpailie(cs, current + 1));
        //交换回来,方便下一次交换.
        swap(cs, current, i);
      }
    }
    return result;
  }

  /**
   * 交换数组第b,e位置上的值
   */
  private void swap(char[] cs, int b, int e) {
    char tmp = cs[b];
    cs[b] = cs[e];
    cs[e] = tmp;
  }

  public Map<Character, Integer> canPermutePalindrome(String s) {
    // 处理空字符串
    if (s.length() == 0) {
      return null;
    }
    HashMap<Character, Integer> result = new HashMap<>();
    char[] arr = s.toCharArray();
    //分别计数每个字符出现的次数
    for (char anArr : arr) {
      if (null != result.get(anArr)) {
        result.put(anArr, result.get(anArr) + 1);
        continue;
      }
      result.put(anArr, 1);
    }
    //如果奇数个字符的数量大于1个,则返回false,否则返回true.
    return result;
  }

  @Test
  public void linkedHashMapTest() {
    Map<String, Integer> test = new LinkedHashMap<>();
    test.put("1", 1);
    test.put("2", 2);
    test.put("4", 4);
    test.put("3", 3);
    System.out.println();
    System.out.print("LinkedHashMap:");
    test.forEach((key, value) -> System.out.print(value));

    //hashmap
    Map<String, Integer> test1 = new HashMap<>();
    test1.put("1", 1);
    test1.put("2", 2);
    test1.put("4", 4);
    test1.put("3", 3);
    System.out.println();
    System.out.print("HashMap:");
    test1.forEach((key, value) -> System.out.print(value));

    //linkedHashMap 按照访问顺序
    Map<String, Integer> test2 = new LinkedHashMap<>(16, 0.75f, true);
    test2.put("1", 1);
    test2.put("2", 2);
    test2.put("4", 4);
    test2.put("3", 3);

    test2.get("4");
    test2.get("2");
    test2.get("3");
    test2.get("1");
    System.out.println();
    System.out.print("linkedHashMap ---with use:");
    test2.forEach((key, value) -> System.out.print(value));
    System.out.println();
  }

  @Test
  public void bo() {
    List<Interval> ha = new ArrayList<>();
    List<Interval> xixi = insert(ha, new Interval(2, 5));
    xixi.stream().forEach(per -> {
      System.out.println(xixi.toString());
    });
  }

  /**
   * 寻找树中最左下角的值
   */
  public int findBottomLeftValue(TreeNode root) {
    TreeNode cur = null;
    //队列
    Queue<TreeNode> queue = new LinkedList();
    //根节点入队
    queue.offer(root);
    while (!queue.isEmpty()) {
      //出队一个元素
      cur = queue.poll();
      //按顺序入队其右孩子和左孩子
      if (cur.right != null) {
        queue.offer(cur.right);
      }
      if (cur.left != null) {
        queue.offer(cur.left);
      }
    }
    //所有元素出队后拿到的就是最后一个节点,返回
    return cur.val;
  }

  public class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  /**
   * @param intervals: Sorted interval list.
   * @param newInterval: new interval.
   * @return: A new interval list.
   */
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    // write your code here
    List<Integer> tmp = new ArrayList<>();
    intervals.stream().forEach(per -> {
      tmp.add(per.start);
      tmp.add(per.end);
    });

    int i = 0, j = 0;
    for (; i < tmp.size() - 1; i++) {
      if (tmp.get(i) <= (newInterval.start) && tmp.get(i + 1) >= newInterval.start) {
        tmp.add(i + 1, newInterval.start);
        break;
      }
    }
    for (; j < tmp.size() - 1; j++) {
      if (tmp.get(j) <= (newInterval.end) && tmp.get(j + 1) >= newInterval.end) {
        tmp.add(j + 1, newInterval.end);
        break;
      }
    }
    if (i == tmp.size() - 1) {
      tmp.add(newInterval.start);
    }
    if (j == tmp.size() - 1) {
      tmp.add(newInterval.end);
    }
    if (tmp.size() == 0){
      tmp.add(newInterval.start);
      tmp.add(newInterval.end);
    }
    Stack<Integer> stack = new Stack<>();
    for (int p = 0; p < tmp.size(); p++) {
      if (!stack.isEmpty() && tmp.get(p).equals(stack.peek())) {
        stack.pop();
      } else {
        stack.push(tmp.get(p));
      }
    }
    List<Integer>tmp1 = new ArrayList<>(stack);

    List<Interval> result = new ArrayList<>();
    for (int k = 0; k < tmp1.size(); k += 2) {
      result.add(new Interval(tmp1.get(k), tmp1.get(k + 1)));
    }

    return result;
  }


  private class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }

  private List<Integer> levelIterator(TreeNode root) {
    List<Integer> resultList = new ArrayList<>();
    if (root == null) {
      return resultList;
    }
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    TreeNode current = null;
    queue.offer(root);//将根节点入队
    while (!queue.isEmpty()) {
      current = queue.poll();//出队队头元素并访问
      if (current != null) {
        resultList.add(current.val);
        queue.offer(current.left);
        queue.offer(current.right);
      } else {
        resultList.add(-1);
      }
    }
    return resultList;
  }

  /**
   * 勒索信
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    //初始化26个小写字母的数组
    int[] letters = new int[26];
    //在杂志中的字符计数
    for (char c : magazine.toCharArray()) {
      letters[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      letters[c - 'a']--;
      //如果某个字符数量小于0,则无法完成,false
      if (letters[c - 'a'] < 0) {
        return false;
      }
    }

    return true;
  }


}
