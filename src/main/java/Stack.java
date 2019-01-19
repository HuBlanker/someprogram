import java.util.ArrayList;

/**
 * created by huyanshi on 2019/1/17
 */
public class Stack {

  private ArrayList<Integer> list = new ArrayList<>();

  public void push(Integer i) {
    //添加元素
    list.add(i);
  }

  public void pop() {
    if (!isEmpty()) {
      //不为空返回最后一个元素
      list.remove(list.size() - 1);
    }
  }

  public Integer top() {
    if (!isEmpty()) {
      //不为空返回最后一个元素
      return list.get(list.size() - 1);
    }
    return 0;
  }

  public boolean isEmpty() {
    return list.size() == 0;
  }

}
