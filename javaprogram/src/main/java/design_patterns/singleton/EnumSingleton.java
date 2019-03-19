package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public enum EnumSingleton {

  SINGLETON;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
