package com.gofdemo.decoratorpatter;

public abstract class AbstractPersonDecorator implements Person {
    protected Person person;

    public AbstractPersonDecorator(Person p) {
        this.person = p;
    }
}
