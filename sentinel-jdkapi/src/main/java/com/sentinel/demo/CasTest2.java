package com.sentinel.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest2 {
    static AtomicInteger casCur = new AtomicInteger(0);
    static Integer syncCur = 0;
    public static void main(String[] args) {
        int threadSize = 1000;
        int maxCount = 2000000;
        casTest(threadSize, maxCount);
        syncTest(threadSize, maxCount);
    }
    public static void casTest(int size, int count) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(()-> {
                while (casCur.get() < count) {
                    casCur.getAndIncrement();
                    if (casCur.get() == count) {
                        System.out.println("casTime:" + (System.currentTimeMillis() - now));
                    }
                }
            }).start();
        }
    }
    public static void syncTest(int size, int count) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(()-> {
                while (syncCur < count) {
                    synchronized ("syncTest") {
                        syncCur++;
                    }
                    if (syncCur == count) {
                        System.out.println("syncTime:"+(System.currentTimeMillis()-now));
                    }
                }
            }).start();
        }
    }
}
