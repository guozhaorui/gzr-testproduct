package com.test.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RedisRateLimiterConfig {
    /**
     * ip限流
     *
     * @return
     */
    @Bean("ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        System.out.println("限流方法");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostString());
    }
}
