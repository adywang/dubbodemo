package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class NoCafCoffee extends Coffee {
    public NoCafCoffee() {
        setDesc("无因咖啡");
        setPrice(BigDecimal.valueOf(5));
    }
}
