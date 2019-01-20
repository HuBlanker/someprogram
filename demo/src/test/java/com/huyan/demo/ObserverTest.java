// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo;

import com.huyan.demo.observer.PC;
import com.huyan.demo.observer.Phone;
import com.huyan.demo.observer.Stock;
import org.junit.Test;

/**
 * created by huyanshi on 2018/12/28
 */
public class ObserverTest {

  @Test
  public void test(){
    //定义一个股票
    Stock stock = new Stock("阿里巴巴");
    //给它添加观察者
    stock.addObserver(new PC());
    stock.addObserver(new Phone());

    //这里阿里巴巴股票大涨!
    stock.stockUp();
    //通知所有观察者
    stock.notifyObservers("阿里巴巴大涨0.01%");

  }

}
