package com.casdemo;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(20, 1);
        new Thread(() -> {
            boolean b;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            b = stampedReference.compareAndSet(20, 200, stampedReference.getStamp(), stampedReference.getStamp() + 1);

            System.out.println("success=" + b + ",stamp=" + stampedReference.getStamp() + ";val=" + stampedReference.getReference().intValue());
            int stamp = stampedReference.getStamp();
            Integer reference = stampedReference.getReference();
            b = stampedReference.compareAndSet(reference, 20, stamp, stamp + 1);
            System.out.println("success=" + b + ",stamp=" + stampedReference.getStamp() + ";val=" + stampedReference.getReference().intValue());
        }, "t1").start();
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            Integer reference = stampedReference.getReference();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean b = stampedReference.compareAndSet(reference, 36, stamp, stamp + 1);
            System.out.println("t2-->success=" + b + ",stamp=" + stamp + ";val=" + reference);
        }, "t2").start();
    }

}
