package daily;

import mian.AbstractMain;

import java.lang.reflect.Modifier;

/**
 * Created by pfliu on 2019/05/09.
 */
public class BitIntTest extends AbstractMain {


    public static void main(String[] args) {
//        new BitIntTest().parseArgsAndRun(args);
        System.out.println("=======");

        long a = (10L << 32) + 20;
        System.out.println(a >> 32);
        System.out.println(a & 0xFFFF);

    }

    @Override
    public void run() {
        int flag = 0;

        flag |= 1;
        System.out.println(Flag.isSet(flag, Flag.TU_TOU));
        System.out.println(Flag.isSet(flag, Flag.INAPACKAGE));

        flag |= 2;
        System.out.println(Flag.isSet(flag, Flag.INAPACKAGE));
        System.out.println(Flag.isSet(flag, Flag.TU_TOU));

        System.out.println(Flag.isAllSet(flag,Flag.TU_TOU,Flag.INAPACKAGE));

        flag |= 3;
        System.out.println(Flag.isAllSet(flag, Flag.INAPACKAGE, Flag.TU_TOU, Flag.INTSHIRT));



    }


    public static final class Flag {
        static int TU_TOU = 1;
        static int INAPACKAGE = 2;
        static int INTSHIRT = 4;


        public static boolean isSet(int flag, int tag) {
            return (flag & tag) == tag;
        }

        public static boolean isAllSet(int flag, int... tags) {
            int tag = 0;
            for (int i : tags) {
                tag |= i;
            }
            return (flag & tag) == tag;
        }
    }
}
