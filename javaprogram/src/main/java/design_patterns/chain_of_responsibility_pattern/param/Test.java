package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public class Test {

  public static void main(String[] args) {

    AbstractParamHandler name = new NameHandler();
    AbstractParamHandler age = new AgeHandler();
    AbstractParamHandler high = new HighHandler();
    name.setNextHandler(age);
    age.setNextHandler(high);

    //成功案例
    Person person = new Person("huyanshi", 23, 172);
    System.out.println(name.handlerRequest(person));

    //名字太长案例
    Person person1 = new Person("huyanshihuyanshi",22 , 122);
    System.out.println(name.handlerRequest(person1));

    //年龄太小
    Person person2 = new Person("huyanshi",-10 , 122);
    System.out.println(name.handlerRequest(person2));
  }
}
