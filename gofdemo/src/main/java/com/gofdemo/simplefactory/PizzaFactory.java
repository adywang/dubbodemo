package com.gofdemo.simplefactory;

public class PizzaFactory {

    public static Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new CheesePizza();
            case "strawberry":
                return new StrawBerryPizza();
            case "pepper":
                return new PepperPizza();
            default:

                return null;
        }
    }
}
