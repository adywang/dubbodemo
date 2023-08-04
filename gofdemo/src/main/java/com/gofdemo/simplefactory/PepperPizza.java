package com.gofdemo.simplefactory;

public class PepperPizza extends Pizza {
    public PepperPizza(){
        this.setName("胡椒披萨");
    }
    @Override
    public void prepare() {
        System.out.println("胡椒披萨准备中！！！");
    }
}
