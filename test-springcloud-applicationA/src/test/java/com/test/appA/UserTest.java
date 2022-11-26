package com.test.appA;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author: gzr
 * date:2022-9-30
 */
public class UserTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                System.out.println("太多了，放不下哦");
            }
        });
        for (; ; ) {



            executor.execute(() -> {
                        for (; ; ) {
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(Thread.currentThread().getName());
                        }
                    }
            );
            System.out.println("线程数量" + executor.getTaskCount());
        }
    }
}
