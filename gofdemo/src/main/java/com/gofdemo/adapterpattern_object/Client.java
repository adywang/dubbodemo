package com.gofdemo.adapterpattern_object;

public class Client {
    public static void main(String[] args) {
        UserServiceAdapter adapter=new UserServiceAdapter(new UserServiceImpl());
        System.out.println(adapter.findById());
        System.out.println(adapter.findList());
    }
}
