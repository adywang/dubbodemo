package com.gofdemo.builderpattern;

public class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder builder) {
        this.houseBuilder = builder;

    }
    public House getHouse() {
        return houseBuilder.buildBase().buildWall().buildRoof().getHouse();
    }
}
