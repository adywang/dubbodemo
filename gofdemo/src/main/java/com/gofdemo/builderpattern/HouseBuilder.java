package com.gofdemo.builderpattern;

public abstract class HouseBuilder {
    private   final House house = new House();

    public   House getHouse() {
        return house;
    }
    public abstract  HouseBuilder  buildWall();
    public abstract  HouseBuilder  buildRoof();
    public abstract  HouseBuilder  buildBase();

}
