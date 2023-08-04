package com.gofdemo.linklist;

public class MySingleLinkList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void showList() {
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    public void del(int id) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                System.out.println("编号id=" + id + "不存在");
                break;
            }
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
                System.out.println(id);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("编号id=" + heroNode.getId() + "不存在");
                break;
            }
            if (temp.getId() == heroNode.getId()) {
                temp.setName(heroNode.getName());
                temp.setNickName(heroNode.getNickName());
                break;
            }
            temp = temp.getNext();
        }
    }
}
