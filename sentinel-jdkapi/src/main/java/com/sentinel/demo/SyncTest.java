package com.sentinel.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SyncTest {

    static volatile int val = 0;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        Object monitor = new Object();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            for (int j = 0; j < 10000; j++) {
                synchronized (monitor) {
                    val++;
                }
            }
            countDownLatch.countDown();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("sync total time:" + (end - start));
        System.out.println(val);
        pool.shutdown();
    }
}
