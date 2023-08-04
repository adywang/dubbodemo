package com.nacos.springcloud.config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {
    @Value("${userInfo.name}")
    private String userName;
    @Value("${userInfo.password}")
    private String password;

    @RequestMapping("/user/info")
    public String userInfo() {
        return "username=" + userName + ";password=" + password;
    }
}
