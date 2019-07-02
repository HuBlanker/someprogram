package daily;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import util.Ticker;

/**
 * Created by pfliu on 2019/06/13.
 */
public class JedisTest {
    private static final Logger logger = LoggerFactory.getLogger(JedisTest.class);
    public static final int TIMES = 100000;


    public static void main(String[] args) {
        Ticker ticker = new Ticker();
        Jedis jedis = new Jedis("192.168.1.251");
        jedis.select(9);

        ticker.tick("start");

        for (int i = 0; i < TIMES; i++) {
            jedis.incr(i + "_1");
        }
        ticker.tick("no pip");

        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < TIMES; i++) {
            pipeline.incr(i + "_2");
        }
        ticker.tick("pip");

        System.out.println(ticker.toString());

    }
}
