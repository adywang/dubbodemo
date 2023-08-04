package com.dubbo;

import com.dubbo.api.OrderService;
import com.dubbo.api.UserService;
import com.dubbo.provider.OrderServiceImpl;
import com.dubbo.provider.UserServiceImpl;
import org.apache.dubbo.config.*;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
//@EnableDubbo
public class MainApp {
    public static void main(String[] args) throws IOException {

//        SpringApplication.run(MainApp.class);
        //服务1
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setInterface(UserService.class);
        userServiceConfig.setRef(new UserServiceImpl());

        //服务2
        ServiceConfig<OrderService> orderServiceConfig = new ServiceConfig<>();
        orderServiceConfig.setRef(new OrderServiceImpl());
        orderServiceConfig.setInterface(OrderService.class);
        //协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);

        //配置中心
        ConfigCenterConfig  configCenter=new ConfigCenterConfig();
        configCenter.setAddress("zookeeper://127.0.0.1:2181");
        configCenter.setProtocol("zookeeper");
        configCenter.setConfigFile("zk-dubbo.properties");
//        configCenter.setNamespace("dubboZookeeper");
        DubboBootstrap instance = DubboBootstrap.getInstance();

        instance.application("dubbo-jdk-provider")
                .protocol(protocolConfig)
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(userServiceConfig)
                .service(orderServiceConfig)
                .configCenter(configCenter)
                .start()
                .await();
    }
}
