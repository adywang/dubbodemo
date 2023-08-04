package com.dubbo.provider;

import com.dubbo.api.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
        return "hello," + name;
    }
}
