package util;

import money.studen_homework.M;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by pfliu on 2019/04/20.
 */
public class FileReadTest {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            RandomAccessFile rafi = new RandomAccessFile("/Users/pfliu/study/someprogram/javaprogram/src/main/java/util/tets.txt", "r");
            FileChannel fci = rafi.getChannel();
            long size = fci.size();
            MappedByteBuffer mbbi = fci.map(FileChannel.MapMode.READ_ONLY, 0, size);
            long start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                byte b = mbbi.get(i);
                System.out.println(b);;
            }
            fci.close();
            rafi.close();
            System.out.println("Spend: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
