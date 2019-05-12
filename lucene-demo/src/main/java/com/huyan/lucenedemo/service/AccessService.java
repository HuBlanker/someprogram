package com.huyan.lucenedemo.service;

import com.alibaba.fastjson.JSONObject;
import com.huyan.lucenedemo.util.JedisCli;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pfliu on 2019/05/12.
 */
@Service
public class AccessService {


    @Value("${redis.url}")
    private String redisUrl;

    public String admin() {

        Jedis jedis = JedisCli.getJedis(redisUrl);

        Map<String, Integer> dataCount = new LinkedHashMap<>();

        for (int i = 0; i < 30; i++) {
            String date = LocalDate.now().minusDays(i).toString();
            String v = jedis.get(date);
            if (v == null || v.equals("")) {
                v = "0";
            }
            dataCount.put(date, Integer.valueOf(v));
        }

        return JSONObject.toJSONString(dataCount);
    }

}
