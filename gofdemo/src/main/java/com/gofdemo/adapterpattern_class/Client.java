package com.gofdemo.adapterpattern_class;

public class Client {
    public static void main(String[] args) {
        UserServiceAdapter adapter=new UserServiceAdapter();
        System.out.println(adapter.findById());
        System.out.println(adapter.findList());
    }
}
