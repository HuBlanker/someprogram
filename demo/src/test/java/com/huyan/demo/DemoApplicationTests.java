package com.huyan.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

  @Test
  public void testJson() {
    HashMap<String, String> hashMap = new HashMap<>();
    Map ha = Collections.synchronizedMap(hashMap);

    JSONObject object = new JSONObject();
    //string
    object.put("string", "string");
    //int
    object.put("int", 2);
    //boolean
    object.put("boolean", true);
    //array
    List<Integer> integers = Arrays.asList(1, 2, 3);
    object.put("list", integers);
    //null
    object.put("null", null);

    System.out.println(object);
  }

  @Test
  public void testJson2() {

    JSONObject object = JSONObject
        .parseObject("{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}");
    //string
    String s = object.getString("string");
    System.out.println(s);
    //int
    int i = object.getIntValue("int");
    System.out.println(i);
    //boolean
    boolean b = object.getBooleanValue("boolean");
    System.out.println(b);
    //list
    List<Integer> integers = JSON
        .parseArray(object.getJSONArray("list").toJSONString(), Integer.class);
    integers.forEach(System.out::println);
    //null
    System.out.println(object.getString("null"));

    JSON.toJSONString(new JSONArray());


  }

  @Test
  public void ha() {
    //从字符串解析JSON对象
    JSONObject obj = JSON.parseObject("{\"runoob\":\"菜鸟教程\"}");
    //从字符串解析JSON数组
    JSONArray arr = JSON.parseArray("[\"菜鸟教程\",\"RUNOOB\"]\n");
    //将JSON对象转化为字符串
    String objStr = JSON.toJSONString(obj);
    //将JSON数组转化为字符串
    String arrStr = JSON.toJSONString(arr);

  }

  @Test
  public void hehe() {

    BigDecimal ha = BigDecimal.TEN;

    System.out.println(BigDecimal.valueOf(Math.atan(ha.doubleValue())).multiply(new BigDecimal("2"))
        .divide(new BigDecimal(Math.PI), 10, BigDecimal.ROUND_UP));

    System.out.println(BigDecimal.valueOf(Math.atan(new BigDecimal("0.88888888").doubleValue()))
        .multiply(new BigDecimal("2"))
        .divide(new BigDecimal(Math.PI), 10, BigDecimal.ROUND_UP));

  }

  @Test
  public void hi() {
    ConcurrentHashMap<String, Integer> test = new ConcurrentHashMap<>();

    test.put("ha", 27);
  }

  @Test
  public void wangyi1() {
    int result = 0;

    Scanner sc = new Scanner(System.in);

    String line1 = sc.nextLine();
    String[] line1Arr = line1.split(" ");

    String line2 = sc.nextLine();
    String[] line2Arr = line2.split(" ");

    int columnNum = Integer.valueOf(line1Arr[0]);
    int m = Integer.valueOf(line1Arr[1]);

    Map<String, Integer> tmp = new HashMap<>();

    for (int i = 0; i < line2Arr.length; i++) {
      if (tmp.containsKey(line2Arr[i])) {
        tmp.put(line2Arr[i], tmp.get(line2Arr[i] + 1));
      }
      tmp.put(line2Arr[i], 1);
    }

    if (tmp.keySet().size() == columnNum) {
      result = tmp.values().stream().mapToInt(per -> {
        return per;
      }).min().getAsInt();

    }
    result = 0;

    System.out.println(result);
  }

  @Test
  public void hahahah() {
    System.out.println(10 >>> 1);
  }


  @Test
  public void volatileTest() {
    long todayStart = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MIN))
        .getTime();
    long todayEnd = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MAX))
        .getTime();

    logger.info(todayStart + "::::::::" + todayEnd);

  }

  @Test
  public void investment() {
    long start = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MIN)).getTime();
    long end = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MAX)).getTime();

    logger.info(start + "");
    logger.info("" + end);
  }

  @Test
  public void time1() {
    long time = Timestamp.valueOf(LocalDateTime.now().minusDays(1)).getTime();
    logger.info(time + "");
    logger.info("==" + dateTimeStrToTimeStamp("2018-11-23 10:00:11"));
  }


  private Long dateTimeStrToTimeStamp(String dateTime) {
    //解析日期
    LocalDateTime localDateTime = LocalDateTime
        .parse(dateTime.substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    //获取时间戳
    return Timestamp.valueOf(localDateTime).getTime();
  }

  public int[] getAns(int[] funds, int a, int b, int c) {
    // Write your code here
    //将abc放入int数组,相当于给abc添加索引
    int[] arr = new int[]{a, b, c};
    for (int i = 0; i < funds.length; i++) {
      //给正确的位置+资金
      arr[judge(arr)] += funds[i];
    }
    return arr;
  }

  /**
   * 获取正确的位置 先比较a,b,再用小的值和c比较,因为只需要去最小.
   *
   * @param arr 当前的abc数组
   * @return 正确位置的索引
   */
  public int judge(int[] arr) {
    //默认为a投资
    int i = 0;
    //如果a>b,给b投资
    if (arr[0] > arr[1]) {
      i = 1;
    }
    //上一步算出的结果如果大于c,给c投资
    if (arr[i] > arr[2]) {
      i = 2;
    }
    return i;
  }


  @Test
  public void test() {

    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);

    a = a.stream().sorted((s1, s2) -> {
      return s2 - s1;
    }).collect(Collectors.toList());

    int i = 1;
  }

  private class A {

    int name;
    List<Integer> params;
  }

  @Test
  public void t() {
    String moves = "DDDDDD";
    char[] cs = moves.toCharArray();
    int u = 0;
    int d = 0;
    int l = 0;
    int r = 0;
    for (char c : cs) {
      switch (c) {
        case 'U':
          u++;
          break;
        case 'D':
          d++;
          break;
        case 'R':
          r++;
          break;
        case 'L':
          l++;
          break;
      }
    }
//    return u - d == 0 && r - l == 0;

  }

  @Test
  public void lcp() {
    String[] ss = new String[10];
    ss[0] = "ABC";
    ss[1] = "ABD";


  }

  public String longestCommonPrefix(String[] strs) {
    // 输入为空
    if (strs.length == 0) {
      return "";
    }
    //取最短的字符串为遍历字符串
    for (int i = 1; i < strs.length; i++) {
      if (strs[0].length() > strs[i].length()) {
        String tmp = strs[0];
        strs[0] = strs[i];
        strs[i] = tmp;
      }
    }
    //如果最短的字符串为空,返回空
    if (strs[0].length() == 0) {
      return "";
    }

    int j = 0;
    for (; j < strs[0].length(); j++) {
      if (!isAllSame(strs, j)) {
        break;
      }
    }

    return strs[0].substring(0, j);
  }

  /**
   * 判断所有字符串在index位置的字符串是否相同
   */
  private boolean isAllSame(String[] strs, int index) {
    char c = strs[0].charAt(index);
    for (String str : strs) {
      if (str.charAt(index) != c) {
        return false;
      }
    }
    return true;
  }

}
