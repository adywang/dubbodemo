package com.gofdemo.singleton;

//懒汉式--线程不安全
public class Demo03 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton03 instance = Singleton03.getInstance();
                Singleton03 instance_1 = Singleton03.getInstance();
                System.out.println(instance_1 == instance);
                System.out.println(instance_1.hashCode() == instance.hashCode());
            }).start();
        }

    }
}

class Singleton03 {
    private static Singleton03 intance = null;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (intance == null) {
            intance = new Singleton03();
        }
        return intance;
    }
}
