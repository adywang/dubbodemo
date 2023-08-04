package com.nacos.jdkapi;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import com.alibaba.nacos.api.naming.pojo.Instance;
import sun.net.spi.nameservice.NameService;

import javax.naming.Name;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Demo1 {
    public static void main(String[] args) throws NacosException, IOException {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        NamingService namingService = NacosFactory.createNamingService(properties);
        namingService.registerInstance("demoserver", "127.0.0.1", 8848);
        namingService.registerInstance("demoserver","127.0.0.1", 8848);
        while (true){

        }
    }

    private static void demo2_server_reg() throws NacosException {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        NamingService namingService = NacosFactory.createNamingService(properties);
        namingService.registerInstance("demoserver", "127.0.0.1", 8848);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        namingService.deregisterInstance("demoserver","127.0.0.1", 8848);
    }

    private static void demo1_configCreate() throws NacosException {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.publishConfig("UserInfo-Api", "DEFAULT_GROUP", "api:\r\tname: api\r\tdesc: api desc", "yaml");
    }

    private static void demo0_get_listen() throws NacosException, IOException {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        ConfigService configService = NacosFactory.createConfigService(properties);

        String config = configService.getConfig("UserInfo", "DEFAULT_GROUP", 100000);
        System.out.println(config);
        configService.addListener("UserInfo", "DEFAULT_GROUP", new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println(configInfo);
            }
        });
        System.in.read();
    }
}
