package design_patterns.strategy;

/**
 * created by huyanshi on 2019/1/7
 */
public class Character {

  String name;

  private Weapon weapon;

  public Character() {
    weapon = new Sword();
  }

  public void attack() {
    weapon.attack();
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

}
