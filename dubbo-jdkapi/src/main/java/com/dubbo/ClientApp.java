package com.dubbo;


import com.dubbo.api.OrderService;
import com.dubbo.api.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class ClientApp {
    public static void main(String[] args) throws IOException {
//        ReferenceConfig<UserService> userServiceReferenceConfig=new ReferenceConfig<>();
//        userServiceReferenceConfig.setInterface(UserService.class);
//        userServiceReferenceConfig.setApplication(new ApplicationConfig("dubbo-jdk-consumer"));
//        userServiceReferenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
//        UserService userService = userServiceReferenceConfig.get();
//        System.out.println(userService.sayHi("james"));
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application("dubboapp");
        ReferenceConfig<OrderService> orderRef=new ReferenceConfig<>();
        orderRef.setInterface(OrderService.class);


        ReferenceConfig<UserService> userRef=new ReferenceConfig<>();
        userRef.setInterface(UserService.class);

        RegistryConfig registryConfig=new RegistryConfig("zookeeper://127.0.0.1:2181");

        bootstrap.reference(orderRef)
                .reference(userRef)
                .registry(registryConfig);
        OrderService orderService = orderRef.get();

        System.out.println(orderService.makeOrder(UUID.randomUUID().toString().replaceAll("-", "")));
        System.out.println(userRef.get());


//        bootstrap.await();
    }
}
