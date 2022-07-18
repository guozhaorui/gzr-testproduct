package com.test.appA.controller;

import com.test.appA.test.TInterface;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("testA")
public class TestController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public String Test(HttpServletResponse response) throws IOException {

        System.out.println("ss");
        return null;
    }

    public static TInterface test() {
        return (s) -> "sss" + s;
    }


    public static void main(String[] args) {
        System.out.println(test().testMethod("1223"));
    }
}
