package com.gofdemo.decoratorpatter;

public class CarPerson extends AbstractPersonDecorator {
    public CarPerson(Person p) {
        super(p);
    }

    @Override
    public void run() {
        super.person.run();
        System.out.println("开车!!!");
    }
}
