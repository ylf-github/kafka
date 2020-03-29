package com.ylf.demo.kafka.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author: leifeng.ye
 * @date: 2020-03-27
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UseRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
//        redisTemplate.opsForHash().put("map","name","战三");
//        System.out.println(redisTemplate.opsForHash().get("map","name"));

//        redisTemplate.opsForList().rightPush("list","2");
//        redisTemplate.opsForList().leftPush("list","1");
//        redisTemplate.opsForList().rightPush("list","3");
//        redisTemplate.opsForList().rightPop("list");
//        List list = redisTemplate.opsForList().range("list", 0, 10);
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }

//          redisTemplate.opsForSet().add("set","hello");
//          redisTemplate.opsForSet().add("set","world");
//          Set set = redisTemplate.opsForSet().members("set");
//          Iterator iterator = set.iterator();
//          while (iterator.hasNext()){
//              System.out.println(iterator.next());
//          }

//            redisTemplate.opsForZSet().add("sortSet","abc",10);
//            redisTemplate.opsForZSet().add("sortSet","bcf",4);
//            redisTemplate.opsForZSet().add("sortSet","fgh",11);
//            Set set = redisTemplate.opsForZSet().range("sortSet", 0, -1);
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()){
//              System.out.println(iterator.next());
//            }
    }
}
