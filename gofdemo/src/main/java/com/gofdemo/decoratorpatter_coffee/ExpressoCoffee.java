package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class ExpressoCoffee extends Coffee{
    public ExpressoCoffee(){
        setDesc("意式咖啡");
        setPrice(BigDecimal.valueOf(12));
    }
}
