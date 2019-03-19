package daily;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by huyanshi on 2019/1/29
 */
public class SerializTest implements Serializable {

  private static int staticValue = 10;

  private int value;

  SerializTest(int value) {
    this.value = value;
  }

  public static void main(String[] args) {
    try {
      //初始化
      SerializTest test = new SerializTest(100);
      //序列化
      ObjectOutputStream oos = new ObjectOutputStream(
          new FileOutputStream("/Users/pfliu/Desktop/serialized.ser"));
      System.out.println(test.value);
      System.out.println(SerializTest.staticValue);
      oos.writeObject(test);

      SerializTest.staticValue = 250;

      //反序列话
      ObjectInputStream ois = new ObjectInputStream(
          new FileInputStream("/Users/pfliu/Desktop/serialized.ser"));
      SerializTest test1 = (SerializTest) ois.readObject();
      System.out.println(test1.value);
      System.out.println(SerializTest.staticValue);


    } catch (Exception e) {
      System.out.println("error");
    }

    new SerializTest(11).test();
  }


  public void test (){
    List<Integer> ha = new ArrayList<>();

    ha.add(2 );

    List<Integer> he = ha.stream().limit(3).collect(Collectors.toList());

    he.forEach(System.out::println);

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    System.out.println(df.format(LocalDateTime.now()));

  }


}
