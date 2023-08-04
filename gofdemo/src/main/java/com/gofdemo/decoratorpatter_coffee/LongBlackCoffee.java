package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class LongBlackCoffee extends Coffee {
    public LongBlackCoffee() {
        setDesc("美式咖啡");
        setPrice(BigDecimal.valueOf(10));
    }
}
