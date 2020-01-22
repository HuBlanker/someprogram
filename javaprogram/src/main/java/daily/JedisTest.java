package daily;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import util.Ticker;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pfliu on 2019/06/13.
 */
public class JedisTest {
//    private static final Logger logger = LoggerFactory.getLogger(JedisTest.class);
//    public static final int TIMES = 100000;


//    public static void main(String[] args) {
////        Ticker ticker = new Ticker();
////        Jedis jedis = new Jedis("192.168.1.251");
////        jedis.select(9);
////
////        ticker.tick("start");
////
////        for (int i = 0; i < TIMES; i++) {
////            jedis.incr(i + "_1");
////        }
////        ticker.tick("no pip");
////
////        Pipeline pipeline = jedis.pipelined();
////        for (int i = 0; i < TIMES; i++) {
////            pipeline.incr(i + "_2");
////        }
////        ticker.tick("pip");
//        Jedis jedis = new Jedis("192.168.1.251");
//        String sb = "";
//        for (long i = 0; i < Math.pow(2, 32); i++) {
//            sb += "a";
//        }
//        jedis.set(sb.toString(), "a");
//        System.out.println("done");
//

//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost");
//        jedis.set("test", "test");
//        byte[] bytes = new byte[1024 * 1024];
//        String str = new String(bytes);
//        // 每次加1MB
//        for (int i = 0; i < 512; i++) {
//            jedis.append("test", str);
//        }
//    }

    public static void main(String [] args){
        Set<Integer> collect = Stream.of(1, 3, 2).filter(e -> e > 2).collect(Collectors.toSet());
        System.out.println(collect);
    }

}
