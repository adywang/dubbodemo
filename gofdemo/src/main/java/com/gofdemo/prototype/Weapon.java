package com.gofdemo.prototype;

public class Weapon implements Cloneable {
    @Override
    protected Object clone()  {
        Weapon clone = null;
        try {
            clone = (Weapon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

    public Weapon(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                '}';
    }
}
