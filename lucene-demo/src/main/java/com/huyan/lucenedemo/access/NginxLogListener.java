package com.huyan.lucenedemo.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pfliu on 2019/05/07.
 */
@Component
public class NginxLogListener {

    @Value("${nginx.log.path}")
    private String fileName;

    @Value("${redis.url}")
    private String redisUrl;

    private final static Logger logger = LoggerFactory.getLogger(NginxLogListener.class);

    private static long lastFileSize;
    private static String LAST_FILE_SIZE_KEY = "last_file_size_key";
    private static String LOG_REGIX = "([^ ]*) ([^ ]*) ([^ ]*) (\\[.*\\]) (\\\".*?\\\") (-|[0-9]*) (-|[0-9]*) (\\\".*?\\\") (\\\".*?\\\")";

    @PostConstruct
    public void listen() {
        final File logFile = new File(fileName);
        Jedis jedis = new Jedis(redisUrl);
        logger.info(" execute the default constructor");

        lastFileSize = Long.valueOf(jedis.get(LAST_FILE_SIZE_KEY) == null ? "0" : jedis.get(LAST_FILE_SIZE_KEY));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleWithFixedDelay(() -> {

            try {
                Thread.currentThread().setName("right-thread");
                long len = logFile.length();
                if (len < lastFileSize) {
                    lastFileSize = 0;
                } else if (len > lastFileSize) {
                    //指定文件可读可写
                    RandomAccessFile randomFile = new RandomAccessFile(logFile, "rw");
                    randomFile.seek(lastFileSize);//移动文件指针位置

                    String tmp = "";
                    while ((tmp = randomFile.readLine()) != null) {
                        // 文件有更新的时候读取全部更新
                        String log = new String(tmp.getBytes("utf-8"));
                        parseLog(log, jedis);
                        logger.info("new log:" + log);
                    }
                    lastFileSize = randomFile.length();
                    jedis.set(LAST_FILE_SIZE_KEY, lastFileSize + "");
                    randomFile.close();
                }

            } catch (Exception e) {
                logger.error(" read file error,now = {}", LocalDateTime.now().toString(), e);

            } finally {
            }
        }, 0, 10, TimeUnit.SECONDS);

    }

    // 解析一条日志
    private void parseLog(String log, Jedis jedis) {
        try {
            Pattern p = Pattern.compile(LOG_REGIX);
            Matcher m = p.matcher(log);

            while (m.find()) {
                // 使用正则表达式进行匹配,之后逐一拿到需要的字段
                String ip = m.group(1);
                String page = m.group(5).replace("\"GET ", "").replace("HTTP/1.1\"", "").trim();
                if (page.startsWith("/") && page.endsWith("/")) {
                    logger.info("current thread :" + Thread.currentThread().getName());
                    logger.info("save : ip = {}, page = {}", ip, page);
                    jedis.incr(LocalDate.now().toString());
                    jedis.incr(decode(page).toLowerCase());
                }
            }
        } catch (Exception e) {
            logger.error("parse error, log={}.", log, e);
        }
    }

    //对url中进行解码,url会将中文变成GBK编码
    public String decode(String s) {
        try {

            return URLDecoder.decode(s, "utf-8");
        } catch (Exception e) {
            logger.error("decode error.s = {}, e= {}", s, e.getMessage(), e);
        }
        return "decode-wrong";
    }

}
