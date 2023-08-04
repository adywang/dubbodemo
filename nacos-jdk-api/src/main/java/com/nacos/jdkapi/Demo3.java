package com.nacos.jdkapi;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;
import java.util.Properties;

public class Demo3 {
    public static void main(String[] args) throws NacosException {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        NamingService namingService = NacosFactory.createNamingService(properties);
        List<Instance> demoserver = namingService.getAllInstances("demoserver");
        for (Instance instance : demoserver) {
            System.out.println(instance.getIp()+":"+instance.getPort()+"->"+instance.getServiceName()+"->"+instance.getClusterName());
        }
    }
}
