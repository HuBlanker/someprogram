// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package javatest;

import java.awt.Panel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JButton;

/**
 * created by pfliu on 2018/11/11
 */
public class InputTest {

  public static void main(String[] args) throws Exception {

//    input1();
//    input2();
  input3();
  }

  public static void input1() throws IOException {

    int i = System.in.read();
    System.out.println(i);

  }

  public static void input2() throws Exception {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String name = br.readLine();
    System.out.println("ReadTest Output:" + name);
  }

  public static void input3() throws Exception {

    Scanner sc = new Scanner(System.in);

    int i = sc.nextInt();//读取int
    float f = sc.nextFloat();//读取float
    String s = sc.nextLine();//读取字符串

    System.out.println(i);
    System.out.println(f);
    System.out.println(s);
  }
}
