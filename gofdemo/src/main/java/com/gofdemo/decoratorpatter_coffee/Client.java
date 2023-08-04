package com.gofdemo.decoratorpatter_coffee;

public class Client {
    public static void main(String[] args) {
        Drink drink=new NoCafCoffee();
        DrinkDecorater chocolate=new WithChocolateDecorator(drink);
        System.out.println(chocolate.cost());

        DrinkDecorater withMilkDecorator = new WithMilkDecorator(chocolate);
        System.out.println(withMilkDecorator.cost());

        withMilkDecorator = new WithMilkDecorator(withMilkDecorator);
        System.out.println(withMilkDecorator.cost());

        withMilkDecorator = new WithSonyDecorator(withMilkDecorator);
        System.out.println(withMilkDecorator.cost());



    }
}
