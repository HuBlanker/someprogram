package test;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by pfliu on 2019/06/17.
 */
public class HTest {

    public static Integer i;

    @Before
    public void before() {
        i = 10;
    }

    @Test
    public void print() {
        boolean x = 1560505161000L < System.currentTimeMillis() - 5 * 24 * 60 * 60 * 1000;
        System.out.println(x);
    }
}