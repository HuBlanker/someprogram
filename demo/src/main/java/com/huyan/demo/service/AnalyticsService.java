package com.huyan.demo.service;

import java.util.List;
import java.util.Map;

/**
 * pfliu at 18/08/09
 */
public interface AnalyticsService {

  /**
   * string,stringbuilder,stringbuffer analytics
   */
  Map<String, Map<String, String>> stringAnalytics();

  /**
   * 字符串查找
   */
  int stringIndex(String big, String small);

  /**
   * 字符串旋转
   */
  String stringRotate(String string, int offset);

  /**
   * fizz buzz
   */
  List<String> fizzBuzz(int n);

  /**
   * 旋转int
   */
  int rotateInt(int number);

  /**
   * 落单的数
   */
  int singleNumber(int[] A);
}
