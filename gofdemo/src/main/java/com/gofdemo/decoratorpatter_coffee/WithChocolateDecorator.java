package com.gofdemo.decoratorpatter_coffee;

import java.math.BigDecimal;

public class WithChocolateDecorator extends DrinkDecorater {
    public WithChocolateDecorator(Drink drink) {
        super(drink);
        this.setPrice(BigDecimal.valueOf(3));
    }

    @Override
    public BigDecimal cost() {
        return this.drink.cost().add(this.getPrice());
    }
}
