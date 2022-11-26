package com.test.appA.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class TestFactoryBean implements FactoryBean<Test1> {

    @Override
    public Test1 getObject() throws Exception {
        return new Test1();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
