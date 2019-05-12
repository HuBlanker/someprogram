package com.huyan.lucenedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.huyan.lucenedemo.service.AccessService;
import com.huyan.lucenedemo.util.JedisCli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by pfliu on 2019/05/08.
 */
@RestController
public class AccessController {

    private final static Logger logger = LoggerFactory.getLogger(AccessController.class);

    private static JSONObject zeroJson = new JSONObject();

    static {
        zeroJson.put("num", "0");
    }


    @Value("${redis.url}")
    private String redisUrl;

    @Resource
    private AccessService service;

    @GetMapping("/count")
    public String access(@RequestParam("s") String s, @RequestParam("callback") String callback) {

        try {
            Jedis jedis = JedisCli.getJedis(redisUrl);
            JSONObject o = new JSONObject();
            String c = jedis.get(s.trim().toLowerCase());
            c = null == c ? "0" : c;
            o.put("num", c);
            return callback + "(" + o.toJSONString() + ")";
        } catch (NumberFormatException e) {
            logger.error("get count from {} error", s, e);
            e.printStackTrace();
        }
        return callback + "(" + zeroJson.toJSONString() + ")";
    }


    @GetMapping("/admin")
    public String admin() {
        return service.admin();
    }
}
