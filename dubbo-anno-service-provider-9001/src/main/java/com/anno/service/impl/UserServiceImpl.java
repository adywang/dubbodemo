package com.anno.service.impl;

import com.dubbo.service.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(loadbalance = "random")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        int i=10/0;
        return "9001--->hi," + name;
    }
}
