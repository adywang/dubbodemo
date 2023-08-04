package com.sentinel.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
    static int maxthread=100000;
    public static void main(String[] args) throws Exception {
         casDemo();
//        Thread.sleep(1000);
//        sync_demo();
    }

    private static void sync_demo() throws InterruptedException {
        PlusDemo demo=new PlusDemo();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(maxthread);

        long start = System.currentTimeMillis();
        for (int i = 1; i <= maxthread; i++) {
            int finalI = i;
            pool.submit(() -> {
                synchronized (demo) {
                    demo.value = demo.value + 1;
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("synchronized使用时间-->" + (end - start));
        pool.shutdown();
    }
    public static void cas_demo() throws InterruptedException {
        AtomicInteger result=new AtomicInteger(0);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(maxthread);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= maxthread; i++) {
            pool.submit(() -> {
                result.getAndIncrement();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("cas使用时间-->" + (end - start));
        pool.shutdown();
    }
    private static void casDemo() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        PlusDemo plusDemo = new PlusDemo();
        long offset = unsafe.objectFieldOffset(PlusDemo.class.getDeclaredField("value"));

        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 500, 60000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));
        CountDownLatch countDownLatch = new CountDownLatch(maxthread);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= maxthread; i++) {
            pool.submit(() -> {
                int value = plusDemo.value;
                while (!unsafe.compareAndSwapInt(plusDemo, offset, value, value + 1)) {
                    value = plusDemo.value;
                    System.out.println("交换失败");
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("cas使用时间-->" + (end - start));
        System.out.println(plusDemo.value);
        pool.shutdown();
    }

    static class PlusDemo {
        private volatile int value = 0;
    }
}
