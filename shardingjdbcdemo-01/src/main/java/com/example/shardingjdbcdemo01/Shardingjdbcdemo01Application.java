package com.example.shardingjdbcdemo01;

import com.example.shardingjdbcdemo01.dao.OrderDao;
import com.example.shardingjdbcdemo01.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class Shardingjdbcdemo01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Shardingjdbcdemo01Application.class, args);
        UserDao userDao = context.getBean(UserDao.class);
        OrderDao orderDao = context.getBean(OrderDao.class);
//        for (int i = 0; i < 10; i++) {
//            userDao.selectList(1);
//        }
//        for (int i = 0; i < 10; i++) {
//            orderDao.insert();
//        }
//        for (int i = 0; i < 10; i++) {
//            userDao.insert(UUID.randomUUID().toString(),Math.abs(UUID.randomUUID().hashCode()));
//        }
//        userDao.selectList(2);
        List<Map> address = orderDao.getAddress(1);
    }

}
