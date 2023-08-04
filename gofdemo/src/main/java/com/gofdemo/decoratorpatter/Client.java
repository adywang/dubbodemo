package com.gofdemo.decoratorpatter;

public class Client {
    public static void main(String[] args) {
        Person p=new SimplePerson();
        BikePerson bikePerson=new BikePerson(p);
        CarPerson carPerson=new CarPerson(bikePerson);
        carPerson.run();
    }

}
