package com.gofdemo.singleton;

//饿汉式---双重检查
public class Demo05 {
}

class Singleton05 {
    private Singleton05() {
    }

    private static volatile Singleton05 instance;

    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                if (instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}