package util;

/**
 * created by huyanshi on 2019/1/19
 */
public class AsyncHttpResponse {

  public int errCode;

  public String errMsg;

  public String content;

  public AsyncHttpResponse() {
    this.errCode = 0;
    this.errMsg = "success";
    this.content = "";
  }

}
