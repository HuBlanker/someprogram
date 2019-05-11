package com.huyan.lucenedemo.util;

import redis.clients.jedis.Jedis;

/**
 * Created by pfliu on 2019/05/08.
 */
public class JedisCli {


   public static  Jedis jedis;

   public static Jedis getJedis(String url){
       if (null == jedis) {
           jedis = new Jedis(url);
       }
       return jedis;
   }
}
