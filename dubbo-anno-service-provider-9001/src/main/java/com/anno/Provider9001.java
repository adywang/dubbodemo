package com.anno;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Provider9001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9001.class);
    }
}
