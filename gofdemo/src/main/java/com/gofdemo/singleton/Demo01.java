package com.gofdemo.singleton;

//饿汉式
public class Demo01 {
    public static void main(String[] args) {
        Singleton01 singleton01=Singleton01.getInstance();
        Singleton01 singleton02 = Singleton01.getInstance();
        System.out.println(singleton02==singleton01);
        System.out.println(singleton02.hashCode()==singleton01.hashCode());
    }
}

class Singleton01 {
    private final static Singleton01 instance = new Singleton01();

    private Singleton01() {

    }

    public static Singleton01 getInstance() {
        return instance;
    }
}
