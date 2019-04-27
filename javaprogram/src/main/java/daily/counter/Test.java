package daily.counter;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by pfliu on 2019/04/22.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Counter<String> cs = new Counter<>();
        cs.add("wode");
        cs.add("wode");

        cs.add("haha");

        cs.add("000");

//        System.out.println(cs.get("wode"));
//        System.out.println(cs.getAll());


    }
}
