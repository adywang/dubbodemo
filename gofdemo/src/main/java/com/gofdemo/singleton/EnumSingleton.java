package com.gofdemo.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum EnumSingleton {
    Instance;
    private AtomicLong atomicLong = new AtomicLong(0);

    private EnumSingleton(){
        System.out.println("init");
    }
    public void increment() {
        atomicLong.getAndIncrement();
    }
    public  long getVal(){
        return  atomicLong.get();
    }

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.Instance;
        instance.increment();
        EnumSingleton instance1 = EnumSingleton.Instance;
        System.out.println(instance1==instance);
    }
}
