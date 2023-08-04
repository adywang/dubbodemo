package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class WithSonyDecorator extends DrinkDecorater {
    public WithSonyDecorator(Drink drink) {
        super(drink);
        this.setPrice(BigDecimal.valueOf(2.5));
    }

    @Override
    public BigDecimal cost() {
        return this.drink.cost().add(this.getPrice());
    }
}
