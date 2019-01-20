package design_patterns.decorator_pattern;

/**
 * created by huyanshi on 2019/1/12
 */
public class Milk extends Decorator {

  public Milk(Component component) {
    super(component);
    this.name = "Milk";
    this.prize = 1.0f;
  }

}
