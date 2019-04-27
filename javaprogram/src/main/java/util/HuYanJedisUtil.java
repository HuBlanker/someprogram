package util;


import redis.clients.jedis.Jedis;

/**
 * Created by pfliu on 2019/04/04.
 */
public class HuYanJedisUtil {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        jedis.mget("in", "test", "wrong").forEach(System.out::println);
    }


}
