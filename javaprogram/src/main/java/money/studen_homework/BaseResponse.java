package money.studen_homework;

public abstract class BaseResponse implements IResponse {

  private Integer responseCode;
  private String responseString;

  @Override
  public Integer getResponseCode() {
    return responseCode;
  }

  @Override
  public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
  }

  @Override
  public String getResponseString() {
    return responseString;
  }

  @Override
  public void setResponseString(String responseString) {
    this.responseString = responseString;
  }
}
