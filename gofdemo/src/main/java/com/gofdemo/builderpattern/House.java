package com.gofdemo.builderpattern;

public class House {
    private String wall;
    private String roof;
    private String base;

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public House() {
    }

    public House(String wall, String roof, String base) {
        this.wall = wall;
        this.roof = roof;
        this.base = base;
    }

    @Override
    public String toString() {
        return "House{" +
                "wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                ", base='" + base + '\'' +
                '}';
    }
}
