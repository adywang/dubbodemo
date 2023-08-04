package com.gofdemo.builderpattern;

public class CommonHouseBuilder extends HouseBuilder{
    @Override
    public HouseBuilder buildWall() {
        super.getHouse().setWall("水泥墙");
        System.out.println("common house build wall");
        return  this;
    }

    @Override
    public HouseBuilder buildRoof() {
        System.out.println("common house build roof");
        super.getHouse().setRoof("尖房顶");
        return  this;
    }

    @Override
    public HouseBuilder buildBase() {
        System.out.println("common house build base");
        super.getHouse().setBase("石头地基");
        return  this;
    }
}
