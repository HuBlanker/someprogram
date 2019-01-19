package design_patterns.strategy;

/**
 * created by huyanshi on 2019/1/7
 */
public class Knight extends Character {

  public Knight (){
    this.name = "Knight";
  }

  @Override
  public void attack() {
    System.out.print("I'm a knight. -----");
    super.attack();
  }
}
