package com.test.appA;

import com.test.appA.component.MqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Resource
    private org.springframework.data.redis.core.StringRedisTemplate RedisTemplate;
    @Resource
    private MqSender mqSender;

    @Test
    public void test() {
        RedisTemplate.opsForValue().set("name", "gzr1sdfsd大幅度反对法大幅度反对法大幅度反对非法大幅度反对反对反对反对对方顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶");
    }

    @Test
    public void test2() {
        mqSender.sendMsg("gzrtest");
    }

    @Test
    public void test3() {
        mqSender.sender("2233232");
    }

}