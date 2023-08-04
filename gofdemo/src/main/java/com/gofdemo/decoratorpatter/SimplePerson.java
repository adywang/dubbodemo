package com.gofdemo.decoratorpatter;

public class SimplePerson implements  Person{
    @Override
    public void run() {
        System.out.println("能走路！！！");
    }
}
