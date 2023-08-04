package com.gofdemo.singleton;

//懒汉式--同步代码块
public class Demo04 {

}

class Singleton04 {
    private Singleton04() {

    }

    private static volatile Singleton04 instance = null;

    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}
