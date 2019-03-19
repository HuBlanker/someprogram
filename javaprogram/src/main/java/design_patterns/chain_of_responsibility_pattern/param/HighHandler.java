package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public class HighHandler extends AbstractParamHandler {

  @Override
  public BaseResponse doCheck(Person person) {
    if (person.high < 40) {
      return new BaseResponse(BaseError.HIGH_TOO_LOW);
    } else if (person.high > 236) {
      return new BaseResponse(BaseError.HIGH_TOO_HIGH);
    }
    return null;
  }
}
