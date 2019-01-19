package asynchttpclient;

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
        .ifPresent(content->{
          System.out.println(content.content);
        });

  }

}
