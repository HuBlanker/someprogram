// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * created by huyanshi on 2018/12/28
 */
public class Stock extends Observable {

  private String name;

  public Stock(String name) {
    this.name = name;
  }

  @Override
  public synchronized void addObserver(Observer o) {
    super.addObserver(o);
  }

  @Override
  public synchronized void deleteObserver(Observer o) {
    super.deleteObserver(o);
  }

  @Override
  public void notifyObservers(Object arg) {
    super.notifyObservers(arg);
  }

  public void stockUp() {
    System.out.println("涨了涨了!牛逼!");
    super.setChanged();
  }

  @Override
  public String toString() {
    return "这里是股票:" + name;
  }
}
