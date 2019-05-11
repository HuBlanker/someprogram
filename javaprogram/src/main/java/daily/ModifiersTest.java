package daily;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by pfliu on 2019/05/10.
 */
public class ModifiersTest {

    private static int age = 999;

    public static void main(String[] args) throws NoSuchFieldException {
        Field myAge = ModifiersTest.class.getDeclaredField("age");
        int ageMod = myAge.getModifiers();


        System.out.println("打印十进制:" + ageMod);
        System.out.println("是否是private:" + Modifier.isPrivate(age));
        System.out.println("是否是final:" + Modifier.isFinal(age));

    }
}
