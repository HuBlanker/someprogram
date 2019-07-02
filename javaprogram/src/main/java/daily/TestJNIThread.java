package daily;

public class TestJNIThread extends Thread {


    @Override
    public void run() {
        //通过JNI调用dll文件执行图片裁剪
        long begin = System.currentTimeMillis();
        long time = System.currentTimeMillis() - begin;
        System.out.println(time);
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            new TestJNIThread().start();
        }
        Thread.sleep(50000);
    }
}