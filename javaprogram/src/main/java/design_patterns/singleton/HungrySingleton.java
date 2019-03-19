package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public class HungrySingleton {
  private static HungrySingleton hungrySingleton = new HungrySingleton();
  private HungrySingleton() {
  }
  public static HungrySingleton getSingleton() {
    return hungrySingleton;
  }
}
