package com.gofdemo.simplefactory;

public class StrawBerryPizza extends Pizza {
    public StrawBerryPizza() {
        this.setName("草莓披萨");
    }

    @Override
    public void prepare() {
        System.out.println("草莓披萨准备中！！！");
    }
}
