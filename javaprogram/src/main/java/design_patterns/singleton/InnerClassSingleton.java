package design_patterns.singleton;

/**
 * created by huyanshi on 2019/1/31
 */
public class InnerClassSingleton {

  private static class Holder {

    private static InnerClassSingleton singleton = new InnerClassSingleton();
  }

  private InnerClassSingleton() {
  }

  public static InnerClassSingleton getSingleton() {
    return Holder.singleton;
  }

}
