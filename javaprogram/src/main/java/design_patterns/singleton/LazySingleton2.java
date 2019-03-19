package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public class LazySingleton2 {

  private static volatile LazySingleton2 lazySingleton = null;

  private LazySingleton2() {
  }

  public static LazySingleton2 getSingleton() {
    synchronized (LazySingleton2.class) {
      if (null == lazySingleton) {
        lazySingleton = new LazySingleton2();
      }
    }
    return lazySingleton;
  }

}
