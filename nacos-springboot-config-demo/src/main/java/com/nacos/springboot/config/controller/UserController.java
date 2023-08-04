package com.nacos.springboot.config.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @NacosValue(value = "${userInfo.name}",autoRefreshed = true)
    private String userName;
    @NacosInjected
    private NamingService namingService;
    @NacosValue(value = "${userInfo.password}",autoRefreshed = true)
    private String password;

    @RequestMapping("/user/info")
    public String userInfo() throws NacosException {

        List<Instance> demoserver = namingService.getAllInstances("demoserver");
        for (Instance instance : demoserver) {
            System.out.println(instance.getServiceName());
        }
        return "username=" + userName + ";password=" + password;
    }
}
