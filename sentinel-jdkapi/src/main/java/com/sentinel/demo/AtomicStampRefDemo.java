package com.sentinel.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampRefDemo {
    static volatile int val = 0;
    static volatile int stamp = 0;

    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(val, stamp);
        CountDownLatch countDownLatch = new CountDownLatch(123);
        for (int i = 0; i < 123; i++) {
            new Thread(() -> {
                int oldVal = stampedReference.getReference().intValue();
                int oldStamp = stampedReference.getStamp();
                boolean b = stampedReference.compareAndSet(oldVal, oldVal + 2, oldStamp, oldStamp +2);
//                while (!b) {
//                    oldVal = stampedReference.getReference().intValue();
//                    oldStamp = stampedReference.getStamp();
//                    b = stampedReference.compareAndSet(oldVal, oldVal + 2, oldStamp, oldStamp + 2);
//                }
                System.out.println("oldval="+oldVal+"--->stamp="+stamp);
                countDownLatch.countDown();

            }).start();
        }
        countDownLatch.await();

        System.out.println(stampedReference.getStamp());
        System.out.println(stampedReference.getReference().intValue());
    }
}
