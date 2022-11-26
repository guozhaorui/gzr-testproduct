package com.test.appA.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    // private static AtomicLong l = new AtomicLong(0L);
    private static Long l = 0L;

    private static ReentrantLock lock = new ReentrantLock();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int m = 0; m < 100; m++) {
                    lock.lock();
                    l++;
                    lock.unlock();
                    if (m == 100) break;
                }
                c.countDown();
            });
        }
        c.await();

        System.out.println(l.longValue());
    }

}
