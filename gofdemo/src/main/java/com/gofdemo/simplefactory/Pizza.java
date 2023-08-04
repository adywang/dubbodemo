package com.gofdemo.simplefactory;

public abstract class Pizza {
    public abstract void prepare();

    private String name;

    public void bak() {
        System.out.println(name + " is baking");
    }

    public void cut() {
        System.out.println(name + " is cutting");
    }

    public void box() {
        System.out.println(name + " is boxing");
    }
    public  void  setName(String name){
        this.name=name;
    }
}
