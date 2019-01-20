package com.huyan.demo;

import com.huyan.demo.strategy.Knight;
import com.huyan.demo.strategy.Spear;
import org.junit.Test;

/**
 * created by huyanshi on 2019/1/7
 */
public class StrategyTest {

  @Test
  public void test(){

    Knight knight = new Knight();
    knight.attack();
    knight.setWeapon(new Spear());
    knight.attack();

  }

}
