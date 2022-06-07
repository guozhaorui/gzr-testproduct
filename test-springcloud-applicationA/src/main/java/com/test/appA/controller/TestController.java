package com.test.appA.controller;

import com.test.appA.test.TInterface;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("testA")
public class TestController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public String Test() {
        stringRedisTemplate.opsForValue().set("ddd", "ddfd");
        return "22";
    }

    public static TInterface test() {
        return (s) -> "sss" + s;
    }


    public static void main(String[] args) {
        System.out.println(test().testMethod("1223"));
    }
}
