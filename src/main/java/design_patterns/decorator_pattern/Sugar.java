package design_patterns.decorator_pattern;

/**
 * created by huyanshi on 2019/1/12
 */
public class Sugar extends Decorator {

  public Sugar(Component component) {
    super(component);
    this.name = "Sugar";
    this.prize = 2.0f;
  }
}
