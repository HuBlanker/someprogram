package com.huyan.demo;

import java.time.LocalDateTime;
import org.junit.Test;

/**
 * created by huyanshi on 2019/1/17
 */
public class NIUDUNTest {


  @Test
  public void te() {
    double max = 0.9999999;
    double min = 0.0000001;
    double k = Math.log(max / min) / 72;
    System.out.println(k);

    System.out.println(LocalDateTime.now().toString());
  }

}
