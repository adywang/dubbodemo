package com.gofdemo.uml.composition;

public class Person {
    private Arm arm=new Arm();
    private Leg leg=new Leg();
    private  Head head=new Head();
    private  Body body=new Body();

    public Person() {
    }
}
