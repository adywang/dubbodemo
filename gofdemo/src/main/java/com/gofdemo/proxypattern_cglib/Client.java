package com.gofdemo.proxypattern_cglib;

public class Client {
    public static void main(String[] args) {
        Object proxy = ProxyFactory.createProxy(new UserService());
        UserService userService = (UserService) proxy;
//        System.out.println(userService.hashCode());
        userService.save();
//        proxy = ProxyFactory.createProxy(new UserService());
//        userService = (UserService) proxy;
//        userService.save();
//        System.out.println(userService.hashCode());
    }
}
