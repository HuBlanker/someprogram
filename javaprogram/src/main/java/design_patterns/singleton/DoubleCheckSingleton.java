package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public class DoubleCheckSingleton {

  private static volatile DoubleCheckSingleton singleton = null;

  private DoubleCheckSingleton() {
  }

  public static DoubleCheckSingleton getSingleton() {
    if (null == singleton) {
      synchronized (DoubleCheckSingleton.class) {
        if (null == singleton) {
          singleton = new DoubleCheckSingleton();
        }
      }
    }
    return singleton;
  }

}
