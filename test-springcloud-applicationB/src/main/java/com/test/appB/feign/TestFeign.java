package com.test.appB.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "application-A", contextId = "create-order")
public interface TestFeign {
    /**
     * 测试有参数的feign调用
     *
     * @return
     */
    @GetMapping(value = "/testA/test1")
    Object testFeign();
}
