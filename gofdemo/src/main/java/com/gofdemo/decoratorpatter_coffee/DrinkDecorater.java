package com.gofdemo.decoratorpatter_coffee;

public abstract class DrinkDecorater extends Drink {
    protected   Drink drink;
    public DrinkDecorater(Drink drink){
        this.drink=drink;
    }
}
