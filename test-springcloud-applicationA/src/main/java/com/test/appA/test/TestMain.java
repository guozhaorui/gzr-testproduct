package com.test.appA.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Object> testMap = new HashMap<>();
        Object val = new Object();
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = finalI * 10000; j < (finalI + 1) * 10000; j++) {
                    testMap.put(j, val);
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();
        for (int i = 0; i < 100000; i++) {
            // assert 很大概率会失败
            if (testMap.get(i) == null) {
                throw new RuntimeException("1122");
            }
        }
    }
}
