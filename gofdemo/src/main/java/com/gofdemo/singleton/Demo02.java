package com.gofdemo.singleton;

public class Demo02 {
    public static void main(String[] args) {
        Singleton02 instance01 = Singleton02.getInstance();
        Singleton02 instance02 = Singleton02.getInstance();
        System.out.println(instance01==instance02);
        System.out.println(instance01.hashCode()==instance02.hashCode());
    }
}

class Singleton02 {
    private final static Singleton02 instance;

    private Singleton02() {
    }

    static {
        instance = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return instance;
    }

}
