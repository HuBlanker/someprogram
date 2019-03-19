package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public class LazySingleton {

  private static LazySingleton lazySingleton = null;

  private LazySingleton() {
  }

  public static LazySingleton getSingleton() {
    if (null == lazySingleton) {
      lazySingleton = new LazySingleton();
    }
    return lazySingleton;
  }
}
