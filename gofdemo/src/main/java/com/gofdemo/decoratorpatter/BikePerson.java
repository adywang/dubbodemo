package com.gofdemo.decoratorpatter;

public class BikePerson extends AbstractPersonDecorator{
    public BikePerson(Person p) {
        super(p);
    }

    @Override
    public void run() {
        super.person.run();
        System.out.println("骑单车!!!");
    }
}
