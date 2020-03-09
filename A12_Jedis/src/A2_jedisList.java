import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

import java.util.List;

public class A2_jedisList {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // lPush 头插     rPush 尾插
    public void redisList1() {
        jedis.lpush("names", "tom", "james", "张飞", "孟德");
        List<String> names = jedis.lrange("names", 0, -1);
        // 头插，先进先出
        System.out.println(names);
    }

    @Test
    // lRange lIndex
    public void redisList2() {
        jedis.lset("names", 1, "云长");
        List<String> names = jedis.lrange("names", 0, -1);
        System.out.println("lRange names 0 -1: " + names);

        System.out.println("lIndex 1: " + jedis.lindex("names", 1));
    }

    @Test
    // lInsert(key,ListPosition,pivot,val)
    public void redisList3() {
        jedis.linsert("names", ListPosition.AFTER, "云长", "翼德");
        jedis.linsert("names", ListPosition.AFTER, "云长", "翼德");
        List<String> names = jedis.lrange("names", 0, -1);
        System.out.println("lRange names 0 -1: " + names);
    }

    @Test
    // lRem(key,count,value)    从key中移出count个value
    public void redisList4() {
        jedis.lrem("names", 2, "翼德");
        List<String> names = jedis.lrange("names", 0, -1);
        System.out.println("lRange names 0 -1: " + names);
    }
}
