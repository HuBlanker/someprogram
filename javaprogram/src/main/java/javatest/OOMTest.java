package javatest;

import java.util.HashMap;
import java.util.Map;

/**
 * created by huyanshi on 2019/3/6
 */
public class OOMTest {

  static class Key{
    int id;

    public Key(int i){
      int id;
    }

    @Override
    public int hashCode() {
      return this.id;
    }
  }

  public static void main(String [] args ) {

    Map<Key, String> testMap = new HashMap<>();
    while (true) {
      for (int i = 0; i < 10000; i++) {
        if (!testMap.containsKey(new Key(i))) {
          testMap.put(new Key(i), "Number:" + i);
        }
      }
    }
  }

}
