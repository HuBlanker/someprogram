// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.service.impl;

import com.huyan.demo.service.AnalyticsService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * created by pfliu on 2018/9/9
 */
@Service
public class AnalyticsServiceImpl implements AnalyticsService {

  @Override
  public Map<String, Map<String, String>> stringAnalytics() {
    Map<String, Map<String, String>> result = new HashMap<>();
    Map<String, String> time = new HashMap<>();
    Map<String, String> memory = new HashMap<>();
    Runtime r = Runtime.getRuntime();

    long pre = System.currentTimeMillis();
    String s = "";
    for (int i = 0; i < 50000; i++) {
      s += i;
    }
    time.put("String", String.valueOf(System.currentTimeMillis() - pre));

    long preBuilder = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 50000; i++) {
      sb.append(i);
    }
    time.put("StringBuilder", String.valueOf(System.currentTimeMillis() - preBuilder));

    long preBuffer = System.currentTimeMillis();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < 50000; i++) {
      stringBuffer.append(i);
    }
    time.put("StringBuffer", String.valueOf(System.currentTimeMillis() - preBuffer));

    result.put("time", time);
    System.out.print(result);
    return result;
  }


  @Override
  public int stringIndex(String source, String target) {
    //多检测下极端值总是没有坏处的.尤其是面试和刷题.
    if (target == null) {
      return -1;
    }
    int pLen = target.length();
    if (pLen == 0 && source != null) {
      return 0;
    }

    if (source == null) {
      return -1;
    }
    int sLen = source.length();
    if (sLen == 0) {
      return -1;
    }

    int i = 0, j = 0;
    char[] src = source.toCharArray();
    char[] ptn = target.toCharArray();
    int[] next = getNext(ptn);
    while (i < sLen && j < pLen) {
      // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
      if (j == -1 || src[i] == ptn[j]) {
        i++;
        j++;
      } else {
        // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
        j = next[j];
      }
    }
    if (j == pLen) {
      return i - j;
    }
    return -1;

  }

  private int[] getNext(char[] p) {
    // 已知next[j] = k,利用递归的思想求出next[j+1]的值
    // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
    // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
    // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
    // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
    int pLen = p.length;
    int[] next = new int[pLen];
    int k = -1;
    int j = 0;
    next[0] = -1; // next数组中next[0]为-1
    while (j < pLen - 1) {
      if (k == -1 || p[j] == p[k]) {
        k++;
        j++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }


  @Override
  public String stringRotate(String string, int offset) {
    if (string.length() == 0) {
      return null;
    }

    offset = offset % string.length();
    char[] charss = string.toCharArray();
    for (int i = 0; i < offset; i++) {
      charss = moveLastToFirst(charss);
    }
    return new String(charss);
  }

  private char[] moveLastToFirst(char[] chars) {
    int l = chars.length - 1;
    char a = chars[l];
    for (; l > 0; l--) {
      chars[l] = chars[l - 1];
    }
    chars[0] = a;
    return chars;
  }

  @Override
  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();
    int i = 1;
    while (i <= n) {
      if (i % 15 == 0) {
        result.add("FizzBuzz");
      } else {
        if (i % 3 == 0) {
          result.add("Fizz");
        } else if (i % 5 == 0) {
          result.add("Buzz\uD83D\uDE04");
        } else {
          result.add(String.valueOf(i));
        }
      }
      i++;
    }
    return result;

  }

  @Override
  public int rotateInt(int number) {
    int result = 0;
    while (number != 0) {
      result = (result * 10) + (number % 10);
      number /= 10;
    }
throw  new NullPointerException();
  }

  @Override
  public int singleNumber(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    int a = A[0];
    for (int i = 1; i < A.length; i++) {
      a ^= A[i];
    }
    return a;
  }

}
