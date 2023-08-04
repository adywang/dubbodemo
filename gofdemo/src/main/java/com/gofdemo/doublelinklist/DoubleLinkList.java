package com.gofdemo.doublelinklist;

public class DoubleLinkList {
    private Node head = new Node(0, "", "");

    public void add(Node n) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = n;
        n.pre = temp;
    }

    public void remove(int id) {
        Node temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if(temp.next!=null){
            temp.next.pre = temp.pre;
        }


    }

    public void list() {
        Node t = head;
        while (true) {
            if (t.next == null) {
                break;
            }
            t = t.next;
            System.out.println(t);
        }

    }
}
