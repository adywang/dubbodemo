package com.gofdemo.doublelinklist;

public class Node {
    public int id;
    public String name;
    public String nickName;
    public Node pre;
    public Node next;

    public Node() {
    }

    public Node(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
