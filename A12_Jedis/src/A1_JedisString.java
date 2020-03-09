import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Redis配置
 * 一、bind bind_ip redis仅能由bind_ip连接和访问
 * 二、requirePass    auth指令需填入密码进行登录验证
 */

public class A1_JedisString {
    private Jedis jedis;

    @Before
    public void initialJedis() {
        jedis = new Jedis("localhost");
        jedis.auth("root");
    }

    @Test
    // set | get
    public void redisString1() {
        jedis.set("user", "tom");
        System.out.println("get tom:" + jedis.get("user"));
    }

    @Test
    // mSet | mGet
    public void redisString2() {
        jedis.mset("age", "20", "gender", "male");
        System.out.println("mget age gender: " + jedis.mget("age", "gender"));
    }

    @Test
    // append setRange getRange
    public void redisString3() {
        // 重置
        jedis.set("user", "tom");
        // append
        jedis.append("user", " is boy");
        System.out.println("get user:" + jedis.get("user"));
        // setRange with offset
        jedis.setrange("user", 7, "girl");
        System.out.println("get user:" + jedis.get("user"));
        // getRange with ^$
        String getRange = jedis.getrange("user", 4, -1);
        System.out.println("getRange user: " + getRange);
    }
}
