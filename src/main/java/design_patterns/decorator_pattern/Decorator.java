package design_patterns.decorator_pattern;

/**
 * created by huyanshi on 2019/1/12
 */
public class Decorator extends Component {

  protected Component component;

  @Override
  public String getName() {
    return name + "," + component.getName();
  }

  @Override
  public float getPrize() {
    return prize + component.getPrize();
  }

  public Decorator(Component component) {
    this.component = component;
  }
}
