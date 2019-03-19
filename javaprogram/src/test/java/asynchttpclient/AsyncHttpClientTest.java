package asynchttpclient;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.Test;
import util.HuYanAsyncHttpCaller;

/**
 * created by huyanshi on 2019/1/19
 */
public class AsyncHttpClientTest {


  @Test
  public void test() {
    HuYanAsyncHttpCaller caller = new HuYanAsyncHttpCaller();
    caller.get("https://www.baidu.com", null, null, 2000, false)
        .ifPresent(content -> {
          System.out.println(content.content);
        });

    LocalDateTime d = LocalDateTime
        .ofInstant(new Date().toInstant(), ZoneId.systemDefault());

    float f = 0.1f;
    int i;
    for (i = 0; i < 1000; i++) {
      f *= 1.01;
      if (f > 10) {
        break;
      }
    }
    System.out.println(i);
    System.out.println(f);

  }


  private BigDecimal normalizedScore(BigDecimal old) {
    return BigDecimal.valueOf(Math.atan(old.doubleValue()))
        .multiply(new BigDecimal("2"))
        .divide(new BigDecimal(Math.PI), 10, BigDecimal.ROUND_UP);


  }


  @Test
  public void test1() {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String [] ss = s.split(" ");
    System.out.println(ss[ss.length - 1].length());
  }

  @Test
  public void ha() {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    System.out.println(s);



  }

}
