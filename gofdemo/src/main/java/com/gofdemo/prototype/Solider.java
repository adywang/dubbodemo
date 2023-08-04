package com.gofdemo.prototype;

import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class Solider implements Cloneable, Serializable {

    private String num;
    private String name;
    private String level;
    private int age;
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Solider(String num, String name, String level, int age) {
        this.num = num;
        this.name = name;
        this.level = level;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Solider{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", age=" + age +
                ", weapon=" + weapon +
                '}';
    }

    @Override
    protected Object clone() {
        Solider clone = null;
        try {
            clone = (Solider) super.clone();
            //深复制
//            clone.setWeapon(new Weapon(this.weapon.getName()));
//            clone.setWeapon((Weapon) this.weapon.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
 
}
