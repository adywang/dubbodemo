package com.sentinel.demo;

import java.time.temporal.ValueRange;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntDemo {
    static AtomicInteger val = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
         AtomicInteger atomicInteger=new AtomicInteger(0);
         atomicInteger.compareAndSet(0,100);
        System.out.println(atomicInteger.get());

        boolean b = atomicInteger.compareAndSet(120, 190);
        int i = atomicInteger.addAndGet(150);
        System.out.println(i);
        System.out.println(b);
        int andAdd = atomicInteger.getAndAdd(12);
        System.out.println(andAdd);
        System.out.println(atomicInteger.get());
    }

    private static void atomic_plus() throws InterruptedException {
        int threadCount = 1000;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            for (int j = 0; j < 10000; j++) {
                val.getAndIncrement();
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
