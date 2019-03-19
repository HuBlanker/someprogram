package com.huyan.demo.protocol;


/**
 * Created by pfliu on 17-6-21.
 */
public class BaseResponse {

  public int errCode;
  public String errMsg;

  public Object result;

  public BaseResponse(BaseError baseError) {
    this.setErrCode(baseError.getCode());
    this.setErrMsg(baseError.getEnMsg());
  }

  public BaseResponse() {
    this.setErrCode(BaseError.SUCCESS.getCode());
    this.setErrMsg(BaseError.SUCCESS.getEnMsg());
  }


  public int getErrCode() {
    return errCode;
  }

  public void setErrCode(int errCode) {
    this.errCode = errCode;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "code=" + errCode + ", msg=" + errMsg + ", money = " + ((result != null) ? result
        .toString() : "");
  }
}
