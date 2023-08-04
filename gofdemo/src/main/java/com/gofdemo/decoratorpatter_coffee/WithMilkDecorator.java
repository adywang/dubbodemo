package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class WithMilkDecorator extends DrinkDecorater {
    public WithMilkDecorator(Drink drink) {
        super(drink);
        this.setPrice(BigDecimal.valueOf(2));
    }

    @Override
    public BigDecimal cost() {
        return this.drink.cost().add(this.getPrice());
    }
}
