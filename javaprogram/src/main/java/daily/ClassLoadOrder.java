package daily;

/**
 * created by huyanshi on 2019/1/28
 */
public class ClassLoadOrder {

  public static void main(String[] args) {
    B b = new B();
  }
}


class A {

  private int i = aFunc();

  static {
    System.out.println("A-----static");

  }

  public int  aFunc() {
    System.out.println("A----- default");
    return 1;
  }

  public A() {
    System.out.println("A----- constructor");

  }
}

class B extends A {

  private static int i1 = staticFunc();

  public B() {
    System.out.println("B----- constructor");
  }

  static {
    System.out.println("B----- static");

  }

  private int i = bFunc();


  private static int  staticFunc(){
    System.out.println("B----- static func");
    return 111;
  }


  public int bFunc() {
    System.out.println("B----- default");
    return 2;
  }
}