package com.nacos.jdkapi;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.util.Properties;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("username", "nacos");
        properties.put("password", "nacos");
        properties.put("serverAddr", "127.0.0.1:8848");
        properties.put("fileExtension", "yml");
        NamingService namingService = NacosFactory.createNamingService(properties);
        namingService.subscribe("demoserver", new EventListener() {
            @Override
            public void onEvent(Event event) {
                NamingEvent e = (NamingEvent) event;
                System.out.println(e.getServiceName());
            }
        });
        while (true) {

        }
    }
}
