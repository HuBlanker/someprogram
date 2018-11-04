// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package fastJson;

import org.springframework.util.DigestUtils;

/**
 * created by pfliu on 2018/9/28
 */
public class JSONTest {

  public static void main(String[] args) {
    String s = "";
    long timestamp = System.currentTimeMillis() / 1000;
    String key = DigestUtils
        .md5DigestAsHex(("mojicmww20160122" + timestamp + "39.888658" + "116.424511").getBytes());
    System.out.println(key);
  }

  public class Product {

    int useTime;
    String createDate;


    public boolean isOverTime(String date) {
      String productLastDate = createDate + useTime;
      return date.compareTo(productLastDate) > 0;
    }
  }

  public class Phone extends Product {
    String model;
  }

  public class Toothbrush extends Product {

    String size;
  }

  //测试，没有纠结具体实现及参数类型
  //传入日期和手机，判断手机是否过期，过期则返回空，不过期则返回该手机
  public Phone huishou(String date, Phone phone) {
    String phoneLastDate = phone.createDate + phone.useTime;
    if (date.compareTo(phoneLastDate) > 0) {
      return null;
    }
    return phone;
  }

}
