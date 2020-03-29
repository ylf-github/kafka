package com.ylf.demo.kafka.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: leifeng.ye
 * @date: 2020-03-25
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
//        redisTemplate.opsForValue().set("aaa","123");
//        redisTemplate.opsForValue().set("bbb","456");
//        redisTemplate.opsForValue().set("ooo","789");
    }
}
