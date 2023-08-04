package com.gofdemo.builderpattern;

public class Main {
    public static void main(String[] args) {
        HouseDirector director=new HouseDirector(new CommonHouseBuilder());
        System.out.println(director.getHouse());
    }
}
