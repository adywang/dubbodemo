package com.anno.service.impl;

import com.dubbo.service.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(loadbalance = "random")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
        return "9003--->hi,"+name;
    }
}
