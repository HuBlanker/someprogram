package daily.weibo;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by pfliu on 2019/05/11.
 */
public class FollowTest1 {

    static String FOLLOW_PREFIX = "follow_";
    static String FANS_PREFIX = "fans_";

    static Jedis jedis = new Jedis();

    public Set<String> getFollows(String id) {
        return jedis.zrange(FOLLOW_PREFIX + id, 0, -1);
    }

    public Set<String> getfans(String id) {
        return jedis.zrange(FANS_PREFIX + id, 0, -1);
    }

    // 获取互相关注的列表
    public Set<String> getTwoFollow(String id) {
        Set<String> follows = getFollows(id);
        Set<String> fans = getfans(id);
        follows.retainAll(fans);
        return follows;
    }

    // 判断from - > to 的关系
    public Followtest.RelationShip getRelationShip(String from, String to) {
        boolean isFollow = getFollows(from).contains(to);
        boolean isFans = getfans(from).contains(to);

        if (isFollow) {
            if (isFans) {
                return Followtest.RelationShip.TWOFOLLOW;
            }
            return Followtest.RelationShip.FOLLOW;
        }
        return isFans ? Followtest.RelationShip.FANS : Followtest.RelationShip.NOONE;
    }

    // 获取共同关注列表
    public Set<String> publicFollow(String id1, String id2) {
        Set<String> id1Follow = getFollows(id1);
        Set<String> id2Follow = getfans(id2);

        id1Follow.retainAll(id2Follow);

        return id1Follow;
    }


    public enum RelationShip {
        FOLLOW, FANS, TWOFOLLOW, NOONE;
    }
}
