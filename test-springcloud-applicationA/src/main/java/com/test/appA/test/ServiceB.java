package com.test.appA.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class ServiceB {
    @Autowired
    private ServiceA serviceA;
}
