package javatest;

/**
 * created by huyanshi on 2019/3/6
 */
public class DeadLockTest {

  public static void main(String[] args) {
    Sy sy = new Sy(0);
    Sy sy2 = new Sy(1);
    sy.start();
    sy2.start();
  }
}

class Sy extends Thread {

  private int flag;

  static Object x1 = new Object();
  static Object x2 = new Object();

  public Sy(int flag) {
    this.flag = flag;
  }

  @Override
  public void run() {
    System.out.println(flag);
    try {
      if (flag == 0) {
        synchronized (x1) {
          System.out.println(flag + "锁住了x1");
          Thread.sleep(1000);
          synchronized (x2) {
            System.out.println(flag + "锁住了x2");
          }
          System.out.println(flag + "释放了x1和x2");
        }
      }
      if (flag == 1) {
        synchronized (x2) {
          System.out.println(flag + "锁住了x2");
          Thread.sleep(1000);
          synchronized (x1) {
            System.out.println(flag + "锁住了x1");
          }
          System.out.println(flag + "释放了x1和x2");
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
