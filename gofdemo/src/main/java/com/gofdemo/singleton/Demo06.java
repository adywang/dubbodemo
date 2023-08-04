package com.gofdemo.singleton;

//静态内部类实现单例模式
//静态内部内在没有调用的情况下不会加载；
//静态内部类的加载过程是线程安全的
public class Demo06 {
    public static void main(String[] args) {

    }
}

class Singleton07 {

    private static class SingletonInner {
        private static final Singleton07 instance = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return SingletonInner.instance;
    }
}
