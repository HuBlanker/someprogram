package cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import com.alicp.jetcache.redis.lettuce.RedisLettuceCacheBuilder;
import com.alicp.jetcache.support.*;
import io.lettuce.core.RedisClient;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Author: pfliu
 * Date:   2020/01/22.
 * Brief:  jetcache 测试
 */
public class JetCacheTest {

    public static void main(String[] args) {
        // 创建一个本地的缓存
        Cache<String, Integer> cache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder()
                .limit(100)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .buildCache();
        // 加入缓存
        cache.put("10", 10);
        // 获取全部缓存
        System.out.println(cache.getAll(Collections.singleton("10")));
        System.out.println(cache.getAll(Collections.singleton("10")));

        // Redis缓存
        RedisClient client = RedisClient.create("redis://127.0.0.1");
        // 创建
        Cache<Long, Integer> orderCache = RedisLettuceCacheBuilder.createRedisLettuceCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .redisClient(client)
                .keyPrefix("orderCache")
                .expireAfterWrite(2000, TimeUnit.SECONDS)
                .buildCache();

        // 添加
        orderCache.put(10000L, 1);
        // 获取并打印
        System.out.println(orderCache.get(10000L));

    }
}
