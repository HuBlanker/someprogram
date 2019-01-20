// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package javatest;

/**
 * created by huyanshi on 2018/11/22
 */
public class VolatileTest {

  private static volatile Boolean stop = false;

  public static void main(String args[]) throws InterruptedException {
    Thread testThread = new Thread() {
      @Override
      public void run() {
        System.out.println();
        int i = 1;
        while (!stop) {
          i++;
        }
        System.out.println("Thread stop i=" + i);
      }
    };
    testThread.start();
    Thread.sleep(1000);
    stop = true;
    System.out.println(Thread.currentThread() + "now, in main thread stop is: " + stop);
    testThread.join();
  }

}
