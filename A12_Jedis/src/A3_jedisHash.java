import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class A3_jedisHash {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // hSet hGet
    public void redisHash1() {
        jedis.hset("iphone", "name", "苹果5");
        System.out.println("hGet iphone name: " + jedis.hget("iphone", "name"));
    }

    @Test
    // hMSet hMGet，直接存入Map
    public void redisHash2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("price", "3999");
        map.put("color", "white");
        jedis.hmset("iphone", map);
        System.out.println("hMGet iphone name price color: "
                + jedis.hmget("iphone", "name", "price", "color"));
    }

    @Test
    // hGetAll  hKeys hValS
    public void redisHash3() {
        System.out.println("hGetALl iphone:(Map) " + jedis.hgetAll("iphone"));

        System.out.println("hKeys iphone: " + jedis.hkeys("iphone"));

        System.out.println("hValS iphone: " + jedis.hvals("iphone"));
    }

    @Test
    // hDel
    public void redisHash4() {
        jedis.hdel("iphone", "color", "price");
        System.out.println(jedis.hgetAll("iphone"));
    }
}
