package design_patterns.strategy;

/**
 * created by huyanshi on 2019/1/7
 */
public class Sword implements Weapon {


  @Override
  public void attack() {
    System.out.println("I'm using a sword!");
  }
}
