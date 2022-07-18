package com.test.appA;

import com.test.appA.component.MqSender;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
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
    public void test3() {
        mqSender.send("exchange_gzr1", "routingKey", "1234");
    }

    @Test
    public void test4() {
        mqSender.send("exchange_gzr2", null, "hgfvdcsxza12345");
    }


    public static void main(String[] args) {
        char a = 'a';

        byte[] b = new byte[2];
        b[0] = (byte) ((a & 0xFF00) >> 8);
        b[1] = (byte) (a & 0xFF);
        System.out.println(b);


        String sss = "sss";
        byte[] ss=sss.getBytes(StandardCharsets.UTF_8);
        System.out.println();
        ;


    }


}