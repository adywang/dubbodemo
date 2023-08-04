package com.casdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SpinLockDemo {

    static class SpinReenterLock implements Lock {

        AtomicReference<Thread> atomicReference = new AtomicReference<>();
        private int count = 0;

        @Override
        public void lock() {
            Thread thread = Thread.currentThread();
            if (thread == atomicReference.get()) {
                count++;
                System.out.println("lock===>thread name " + thread.getName() + "===>count " + count);
                return;
            }
            while (!atomicReference.compareAndSet(null, thread)) {
                Thread.yield();
            }
            System.out.println("lock===>thread name " + thread.getName() + "===>count " + count);


        }


        @Override
        public void unlock() {
            Thread thread = Thread.currentThread();
            if (thread == atomicReference.get()) {
                if (count > 0) {
                    System.out.println("unlock===>thread name " + thread.getName() + "===>count " + count);
                    count--;
                } else {
                    atomicReference.set(null);
                    System.out.println("unlock===>thread name " + thread.getName() + "===>count " + count);
                }
            }
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }


        @Override
        public Condition newCondition() {
            return null;
        }
    }

    static class SpinkLock implements Lock {
        private AtomicReference<Thread> atomicReference = new AtomicReference<>();

        @Override
        public void lock() {
            Thread thread = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, thread)) {
                Thread.yield();
            }
        }

        @Override
        public void unlock() {
            Thread thread = Thread.currentThread();
            if (atomicReference.get() == thread) {
                atomicReference.set(null);
            }
            System.out.println("unlock threadName " + Thread.currentThread().getName());
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }


        @Override
        public Condition newCondition() {
            return null;
        }
    }

    static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void main(String[] args) throws Exception {
        SpinReenterLock reenterLock = new SpinReenterLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            reenterLock.lock();
            reenterLock.lock();
            reenterLock.lock();
            reenterLock.unlock();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
            reenterLock.unlock();
            reenterLock.unlock();
            countDownLatch.countDown();
        }, "t1").start();
        new Thread(() -> {
            reenterLock.lock();
            reenterLock.lock();
            reenterLock.lock();
            reenterLock.unlock();
            reenterLock.unlock();
            countDownLatch.countDown();
        }, "t2").start();
        countDownLatch.await();
    }

    private static void spinLick_no_reenter() {
        SpinkLock spinkLock = new SpinkLock();
        new Thread(() -> {
            spinkLock.lock();
            System.out.println("spin lock " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spinkLock.unlock();
        }, "t1").start();

        new Thread(() -> {
            spinkLock.lock();
            System.out.println("spin lock " + Thread.currentThread().getName());
            spinkLock.unlock();
        }, "t2").start();
    }

    private static void spinLockDemo1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("threadName " + Thread.currentThread().getName());
            lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock threadName " + Thread.currentThread().getName());
            unlock();
            countDownLatch.countDown();
        }, "t1").start();

        new Thread(() -> {
            System.out.println("threadName " + Thread.currentThread().getName());
            lock();

            System.out.println("lock threadName " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unlock();
            countDownLatch.countDown();
        }, "t2").start();
        countDownLatch.await();
    }

    public static void lock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {
            Thread.yield();
        }
    }

    public static void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == atomicReference.get()) {
            System.out.println("unlock threadName " + Thread.currentThread().getName());
            atomicReference.set(null);
        }

    }
}
