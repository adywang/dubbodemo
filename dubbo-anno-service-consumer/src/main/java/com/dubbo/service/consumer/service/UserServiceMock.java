package com.dubbo.service.consumer.service;

import com.dubbo.service.api.UserService;

public class UserServiceMock implements UserService {
    @Override
    public String sayHi(String name) {
        return "系统繁忙请稍后重试！！！o(╥﹏╥)o";
    }
}
