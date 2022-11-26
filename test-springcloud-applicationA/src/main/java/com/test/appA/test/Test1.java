package com.test.appA.test;

public class Test1 {
    private static int i = 1;

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    // System.out.println("线程1正在执行");
                } while (i == 1);
            }
        }).start();

        Thread.sleep(1000L);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    i = 2;
                }
            }
        }).start();
    }
}
