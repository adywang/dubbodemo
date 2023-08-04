package com.dubbo.service.consumer.controller;

import com.dubbo.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    //    loadbalance
    //负载均衡，可用于客户端调用，也适用于服务提供端
    //    算法	特性	备注	配置值
    //    Weighted Random LoadBalance	加权随机	默认算法，默认权重相同	random (默认)
    //    RoundRobin LoadBalance	加权轮询	借鉴于 Nginx 的平滑加权轮询算法，默认权重相同，	roundrobin
    //    LeastActive LoadBalance	最少活跃优先 + 加权随机	背后是能者多劳的思想	leastactive
    //    Shortest-Response LoadBalance	最短响应优先 + 加权随机	更加关注响应速度	shortestresponse
    //    ConsistentHash LoadBalance	一致性哈希	确定的入参，确定的提供者，适用于有状态请求	consistenthash
    //    P2C LoadBalance	Power of Two Choice	随机选择两个节点后，继续选择“连接数”较小的那个节点。	p2c
    //    Adaptive LoadBalance	自适应负载均衡	在 P2C 算法基础上，选择二者中 load 最小的那个节点	adaptive
    //    mock:服务降级
    @DubboReference(loadbalance = "roundrobin", mock = "com.dubbo.service.consumer.service.UserServiceMock")
    private UserService userService;

    @RequestMapping("/user/hi")
    public String sayHi(String name) {
        log.info("sayhi-------------------------");
        return userService.sayHi(name);
    }
}
