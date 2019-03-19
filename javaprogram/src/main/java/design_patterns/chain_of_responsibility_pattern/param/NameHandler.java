package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public class NameHandler extends AbstractParamHandler {

  @Override
  public BaseResponse doCheck(Person person) {
    if (person.name == null || person.name.length() < 1) {
      return new BaseResponse(BaseError.NAME_TOO_SHORT);
    } else if (person.name.length() > 10) {
      return new BaseResponse(BaseError.NAME_TOO_LONG);
    }
    return null;
  }
}
