package com.sentinel.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CasTest3 {
    static class CasPlus {
        private volatile int value = 0;
        private Unsafe unsafe;
        private long offset;

        public CasPlus() {
            try {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                unsafe = (Unsafe) theUnsafe.get(null);
                offset = unsafe.objectFieldOffset(this.getClass().getDeclaredField("value"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void plusOne() {
            int oldVal = value;
//            unsafe.compareAndSwapInt(this, offset, oldVal, oldVal + 1);
            while (!unsafe.compareAndSwapInt(this, offset, oldVal, oldVal + 1)) {
                oldVal = value;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int threadCount = 1000;
        CasPlus casPlus = new CasPlus();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            pool.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    casPlus.plusOne();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("cas total time:" + (end - start));
        System.out.println(casPlus.value);
        pool.shutdown();
    }
}
