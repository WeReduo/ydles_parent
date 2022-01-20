import redis.clients.jedis.Jedis;

/**
 * Project Name: ydles_parent
 * File Name: RedisTest
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/19/下午 3:23
 * Copyright (c) 2022,
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis =new Jedis("192.168.200.128",6379); //测试地址
        for (int i = 0; i <10 ; i++) {
            Long id = jedis.incr("id");
            System.out.println(id);
        }

    }
}
