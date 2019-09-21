package test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by pfliu on 2019/08/20.
 */
public class JedisPoolTest {

    private static final String PREFIX = "prefix";
    private ExecutorService work = Executors.newFixedThreadPool(20);

    private JedisPool countRedis;

    @Before
    public void b() {
        this.countRedis = new JedisPool(new GenericObjectPoolConfig(), "localhost", 6379, 2000, null, 6);
        System.out.println(countRedis.getResource().keys("**"));
    }

    /**
     * 是否应该召回,如果redis已经存在,则说明今天此方式推送过了,打印错误日志,然后不执行召回
     */
    private boolean shouldCalBack(String key) {
        try (Jedis jedis = this.countRedis.getResource()) {
            jedis.set(key, "1");
            return jedis.get(key) == null;
        } catch (Exception e) {
            System.out.println("catch error in b50 push count" + e);
            return false;
        }
    }


    @Test
    public void test() {

        for (int i = 0; i < 100; i++) {
            Runnable a = this::a;
            work.submit(a);
        }


    }


    public void a() {
        while (true) {
            Random r = new Random();
            System.out.println(shouldCalBack(PREFIX + r.nextInt(10)));
        }

    }


}
