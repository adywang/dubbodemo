package com.shardingdemo.shardingdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.proxy.DruidDriver;
import com.shardingdemo.shardingdemo.dao.OrderDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShardingdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShardingdemoApplication.class, args);
        OrderDao orderDao = context.getBean(OrderDao.class);
        List<Map> one = orderDao.getOne(5);
        one = orderDao.getOne(2);
        for (Map map : one) {
            System.out.println(map);
        }
        for (int i = 0; i < 10; i++) {
            orderDao.insert();
        }


    }

}
