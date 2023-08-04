package com.dubbo.provider;

import com.dubbo.api.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public String makeOrder(String orderid) {
        return "make order ,orderid--->" + orderid;
    }
}
