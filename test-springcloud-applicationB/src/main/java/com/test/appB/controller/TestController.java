package com.test.appB.controller;

import com.test.appB.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testB")
public class TestController {
    @Autowired
    private TestFeign testFeign;
    @Value("${name}")
    private String name;

    @GetMapping("/test1")
    public String Test() {
        System.out.println(name);
        System.out.println(testFeign.testFeign());
        return "33";
    }
}
