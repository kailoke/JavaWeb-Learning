import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Set;

/**
 * SortedSet
 * 在Set基础上维护double类型的score属性，根据score提供rank和搜索方法
 * > range
 * > rank
 * > score
 */

public class A5_JedisSortedSet {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // zAdd zRange(^$) zRangeByScore(key,min,max)
    public void redisZSet1() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("孔融", 20.0);
        map.put("卢植", 25.0);
        map.put("刘宠", 60.5);
        map.put("刘表", 19.6);
        // 自然排序
        jedis.zadd("force", map);

        System.out.println("zRange force: " + jedis.zrange("force", 0, -1));

        System.out.println("zRangeByScore force 21 100: " +
                jedis.zrangeByScore("force", 21, 100));
    }

    @Test
    // zRangeWithScores
    public void redisZSet2() {
        Set<Tuple> force = jedis.zrangeWithScores("force", 0, -1);
        for (Tuple tuple : force) {
            System.out.println(tuple);
//            System.out.println(tuple.getElement() + " : " + tuple.getScore());
        }
    }

    @Test
    // zScore(key,value)：获取值的score
    // zRank(key,value)：获取值的排序index(0 ~ ...)
    public void redisZSet3() {
        System.out.println("zScore force 刘宠: " + jedis.zscore("force", "刘宠"));
        System.out.println("zRank force 刘宠: " + jedis.zrank("force", "刘宠"));
    }
}
