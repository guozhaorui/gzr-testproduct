package com.test.appA.controller;

import com.test.appA.dao.JProductDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Resource
    private JProductDao productDao;

    @GetMapping("testQuery")
    public void testQuery() {
        System.out.println("当前线程名称:" + Thread.currentThread().getName());
        Long start = System.currentTimeMillis();
        productDao.queryByName("测试商品1658911576919");
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
