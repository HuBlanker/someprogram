package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public class BaseResponse {

  private int errCode;
  private String errMsg;

  private String content;

  public BaseResponse(BaseError error){
    this.errCode = error.errCode;
    this.errMsg = error.errMsg;
  }

  @Override
  public String toString() {
    return "errCode:" + errCode + ";" + "errMsg" + errMsg;
  }
}
