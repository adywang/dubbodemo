package com.gofdemo.doublelinklist;

public class Main {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.add(new Node(1,"tt1","tttt1"));
        doubleLinkList.add(new Node(2,"tt2","tttt2"));
        doubleLinkList.add(new Node(3,"tt3","tttt3"));
        doubleLinkList.add(new Node(4,"tt4","tttt4"));
        doubleLinkList.add(new Node(5,"tt5","tttt5"));
        doubleLinkList.add(new Node(6,"tt6","tttt6"));
        doubleLinkList.add(new Node(7,"tt7","tttt7"));
        doubleLinkList.remove(2);
        System.out.println("");
        doubleLinkList.list();

        doubleLinkList.remove(5);
        System.out.println("");
        doubleLinkList.list();

        doubleLinkList.remove(7);
        System.out.println("");
        doubleLinkList.list();
    }
}
