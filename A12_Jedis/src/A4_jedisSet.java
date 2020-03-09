import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Set集合操作
 * > intersection  交集 inter
 * > union         并集 union
 * > different     差集 diff
 */
public class A4_jedisSet {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // sAdd sMembers sCard
    public void redisSet() {
        jedis.sadd("language", "java", "c/c++", "python", "ruby");
        System.out.println("sMembers language: " + jedis.smembers("language"));

        System.out.println("sCard language: " + jedis.scard("language"));
    }
}
