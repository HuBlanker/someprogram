// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * created by huyanshi on 2018/12/28
 */
public class PC implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println("------------PC已经更新.");
    System.out.println(arg.toString());
  }
}
