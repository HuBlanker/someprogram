package daily.gctest;

/**
 * Created by pfliu on 2019/08/09.
 */
public class ReferenceCountTest {

    public static final byte[] MB1 = new byte[1024 * 1024];
    public ReferenceCountTest reference;

    public static void main(String[] args) {

        ReferenceCountTest a = new ReferenceCountTest();
        ReferenceCountTest b = new ReferenceCountTest();

        a.reference = b;
        b.reference = a;

        a = null;
        b = null;

        System.gc();

    }
}
