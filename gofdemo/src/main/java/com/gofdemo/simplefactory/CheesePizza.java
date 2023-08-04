package com.gofdemo.simplefactory;

public class CheesePizza extends Pizza {
    public  CheesePizza(){
        this.setName("奶酪");
    }
    @Override
    public void prepare() {
        System.out.println("奶酪披萨准备中！！！");
    }
}
