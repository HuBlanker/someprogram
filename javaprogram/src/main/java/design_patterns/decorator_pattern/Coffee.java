package design_patterns.decorator_pattern;

/**
 * created by huyanshi on 2019/1/12
 */
public class Coffee extends Component {


  public Coffee() {
    this.name = "coffee";
    this.prize = 10.0f;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public float getPrize() {
    return prize;
  }
}
