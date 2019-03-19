package javatest;

/**
 * created by huyanshi on 2019/3/6
 */
public class StackOverFlowTest {


  public static void main(String[] args) {

    new StackOverFlowTest().fun(10);
  }


  public int fun(int n) {
    return fun(n);
  }

}
