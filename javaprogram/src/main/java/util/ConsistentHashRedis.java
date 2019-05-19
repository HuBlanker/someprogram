package util;

import redis.clients.jedis.Jedis;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by pfliu on 2019/05/19.
 */
public class ConsistentHashRedis {

    // 用跳表模拟一致性hash环,即使在节点很多的情况下,也可以有不错的性能
    private final ConcurrentSkipListMap<Integer, String> circle;
    // 虚拟节点数量
    private final int virtual_size;

    public ConsistentHashRedis(String configs) {
        this.circle = new ConcurrentSkipListMap<>();
        String[] cs = configs.split(",");
        this.virtual_size = getVirtualSize(cs.length);
        for (String c : cs) {
            this.add(c);
        }
    }

    /**
     * 将每个节点添加进环中,并且添加对应数量的虚拟节点
     */
    private void add(String c) {
        if (c == null) return;
        for (int i = 0; i < virtual_size; ++i) {
            String virtual = c + "-N" + i;
            int hash = getHash(virtual);
            circle.put(hash, virtual);
        }
    }

    // 根据字符串获取hash值,这里使用简单粗暴的绝对值.
    private int getHash(String s) {
        return Math.abs(s.hashCode());
    }

    // 计算当前需要多少个虚拟节点,这里没有计算,直接使用了150.
    private int getVirtualSize(int length) {
        return 150;
    }

    /**
     * 对外提供的set方法
     */
    public void set(String key, String v) {
        getJedisFromCircle(key).set(key, v);
    }

    public String get(String k) {
        return getJedisFromCircle(k).get(k);
    }

    /**
     * 从环中取到适合当前key的jedis.
     */
    private Jedis getJedisFromCircle(String key) {
        int keyHash = getHash(key);
        ConcurrentNavigableMap<Integer, String> tailMap = circle.tailMap(keyHash);
        String config = tailMap.isEmpty() ? circle.firstEntry().getValue() : tailMap.firstEntry().getValue();
        // 注意,由于使用了虚拟节点,所以这里要做 虚拟节点 -> 真实节点的映射
        String[] cs = config.split("-");
        return new Jedis(cs[0]);
    }

    /**
     * 对外暴露的添加节点接口
     */
    public boolean addJedis(String cs) {
        add(cs);
        return true;
    }

    /**
     * 对外暴露的删除节点节点
     */
    public boolean deleteJedis(String cs) {
        delete(cs);
        return true;
    }

    /**
     * 从环中删除一个节点极其虚拟节点
     */
    private void delete(String cs) {
        if (cs == null) return;
        for (int i = 0; i < virtual_size; ++i) {
            String virtual = cs + "-N" + i;
            int hash = getHash(virtual);
            circle.remove(hash, virtual);
        }
    }
}
