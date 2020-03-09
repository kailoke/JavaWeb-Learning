import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Redis Key(键)的操作
 */

public class A0_jedisKey {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // keys del type rename dump exists
    public void redisKey1() {
        Set<String> keys = jedis.keys("*");
        System.out.println("keys *: " + keys);

        System.out.println("type iphone: " + jedis.type("iphone"));

        System.out.println("exists gender: " + jedis.exists("gender"));
    }

    @Test
    // expiry
    // expire(key,secs) TTL(key)获取expiry
    // persist(key)移出expireTime
    public void redisKey2() {
        jedis.expire("user1",10);
        System.out.println(jedis.ttl("user1")); // -2?
    }
}
