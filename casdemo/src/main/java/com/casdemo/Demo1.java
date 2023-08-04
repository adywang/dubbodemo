package com.casdemo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo1 {

    static class UserInfo {
        volatile int age;
        String username;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public UserInfo(int age, String username) {
            this.age = age;
            this.username = username;
        }

        public UserInfo() {
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "age=" + age +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

    static volatile UserInfo user = new UserInfo(18, "admin");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        int initVaL = 10;
        int stamp = 1;
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(initVaL, stamp);
        new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(100) * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1--1-->" + atomicStampedReference.compareAndSet(initVaL, initVaL+1 , stamp, stamp + 1));
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(100) * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2--1-->" + atomicStampedReference.compareAndSet(initVaL, initVaL+1, stamp, stamp + 1));
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
    }

    private static void atomicRefDemo() throws InterruptedException {
        AtomicReference<UserInfo> userRef = new AtomicReference<>();
        AtomicInteger failCount = new AtomicInteger(0);
        userRef.set(user);
        CountDownLatch countDownLatch = new CountDownLatch(500);
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(() -> {
                UserInfo u = new UserInfo(finalI + 20, "admin" + finalI);
                while (!userRef.compareAndSet(user, u)) {
                    user = userRef.get();
                    System.out.println("交换失败");
                    failCount.getAndIncrement();
                }
                System.out.println(u);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("执行完成,发生cas失败次数是" + failCount.get());
    }


    private static void atomicIntegerDemo() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    atomicInteger.getAndIncrement();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("结果：" + atomicInteger.get());
    }

}
