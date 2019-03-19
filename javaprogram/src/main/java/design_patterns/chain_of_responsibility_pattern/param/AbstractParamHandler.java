package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public abstract class AbstractParamHandler {

  private AbstractParamHandler nextHandler;

  public void setNextHandler(
      AbstractParamHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public BaseResponse handlerRequest(Person person) {
    BaseResponse response = doCheck(person);
    if (null == response) {
      if (this.nextHandler != null) {
        return this.nextHandler.handlerRequest(person);
      } else {
        return new BaseResponse(BaseError.SUCCESS);
      }
    }
    return response;
  }

  public abstract BaseResponse doCheck(Person person);
}
