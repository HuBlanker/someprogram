package daily.bitmap;


import com.googlecode.javaewah.EWAHCompressedBitmap;
import daily.SerializTest;
import redis.clients.jedis.Jedis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.BitSet;

/**
 * Created by pfliu on 2019/07/01.
 */
public class EWAHTest {

     EWAHCompressedBitmap hhhhh = EWAHCompressedBitmap.bitmapOf(10);


    public static void main(String [] args){
        EWAHTest ewahTest = new EWAHTest();
        ewahTest.hhhhh.addWord(10);
        ewahTest.hhhhh.set(55);



        System.out.println(ewahTest.hhhhh.get(10));
        System.out.println(ewahTest.hhhhh.get(55));
    }



}

class JavaBitMapTest {
    public static void main(String [] args) throws IOException {
        EWAHCompressedBitmap bs = new EWAHCompressedBitmap();

        bs.set(1000000000);

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/Users/pfliu/Desktop/serialized_ewah.ser"));
        oos.writeObject(bs);


        System.out.println(bs.get(10));
        System.out.println(bs.get(11));


        Jedis j = new Jedis("localhost");
        String v = j.get("key");
        System.out.println(v);

    }
}
