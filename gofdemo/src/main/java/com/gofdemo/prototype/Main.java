package com.gofdemo.prototype;

public class Main {
    public static void main(String[] args) {
        Sheep sheep=new Sheep(1,"多利羊","美国",4);
        Sheep sheep1 = sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep==sheep1);
        sheep1.setName("多利羊2");
        System.out.println(sheep);
        System.out.println(sheep1);
        Solider solider=new Solider("num001","张三","士官",23);
        solider.setWeapon(new Weapon("冲锋枪"));
        Solider clone = (Solider)solider.clone();
        Object clone1 = solider.clone();
        solider.setName("klkkk");
        System.out.println(clone1);
        System.out.println(clone);
        solider.getWeapon().setName("手雷");
        System.out.println(clone1);
        System.out.println(clone);
    }
}
