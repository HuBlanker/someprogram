package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public class AgeHandler extends AbstractParamHandler {

  @Override
  public BaseResponse doCheck(Person person) {
    if (person.age < -0.9) {
      return new BaseResponse(BaseError.AGE_TOO_SMALL);
    } else if (person.age > 1000) {
      return new BaseResponse(BaseError.AGE_TOO_BIG);
    }
    return null;
  }
}
