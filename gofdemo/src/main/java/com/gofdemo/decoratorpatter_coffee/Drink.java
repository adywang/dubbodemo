package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public abstract class Drink {
    protected String desc;
    protected BigDecimal price;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract  BigDecimal cost();
}
