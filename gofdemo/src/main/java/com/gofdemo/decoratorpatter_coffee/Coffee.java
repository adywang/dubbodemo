package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class Coffee extends Drink {
    @Override
    public BigDecimal cost() {
        return super.getPrice();
    }
}
