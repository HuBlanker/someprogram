package daily;

import static com.huyan.StringUtils.containChinese;

/**
 * Created by pfliu on 2019/09/09.
 */
public class StringChineseTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("the hook is done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        System.out.println(containChinese("wodaodafdaf"));
        System.out.println(containChinese("我的世界"));
        System.out.println(containChinese("我的adfafadf"));
        Thread.sleep(1000000000);

    }
}
