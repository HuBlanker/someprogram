package daily;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import mian.AbstractMain;
import org.kohsuke.args4j.Option;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by pfliu on 2019/04/08.
 */
public class RedisTest extends AbstractMain implements Serializable {

    @Option(name = "-t", usage = "the type of redis save")
    private boolean type = true;


    @Override
    public void run() {

        Jedis jedis = new Jedis("localhost");

        User user = new User();
        user.name = "name1";
        user.name1 = "name";
        user.name2 = "name2";
        user.name3 = "name3";
        user.name4 = "name4";

        user.age = 1;
        user.age2 = 2;
        user.age3 = 3;

        int i = 0;
        long ts1 = System.currentTimeMillis();
        while (i < 1000000) {
            user.phone = i;
            String s = JSON.toJSONString(user);
            jedis.set(i + "json", s);
            ++i;
        }
        logger.info("json : {}", System.currentTimeMillis() - ts1);

        i = 0;

        long ts2 = System.currentTimeMillis();
        while (i < 1000000) {
            user.phone = i;
            byte[] s = toByteArray(user);
            jedis.set(toByteArray(i + "byte"), s);
            ++i;
        }
        logger.info("byte : {}", System.currentTimeMillis() - ts2);

    }

    public static void main(String[] args) {
        new RedisTest().parseArgsAndRun(args);
    }

    class User implements Serializable {
        String name;
        String name1;
        String name2;
        String name3;
        String name4;

        int age;
        int age2;
        int age3;

        long phone;

    }

    public byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }


}
