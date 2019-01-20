package design_patterns.decorator_pattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * created by huyanshi on 2019/1/12
 */
public class DecoratorPatternMain {

  public static void main(String[] args) throws IOException {

//    Component coffee = new Coffee();
//    coffee = new Milk(coffee);
//    coffee = new Milk(coffee);
//    coffee = new Sugar(coffee);
//    System.out.print(coffee.getName() + coffee.getPrize());

    InputStream in = new CuteInputStream(new FileInputStream("/Users/pfliu/study/test/test.txt"));
    int c;
    try{
      while ( (c=in.read()) >=0){
        System.out.print((char)(c));
      }
      in.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
