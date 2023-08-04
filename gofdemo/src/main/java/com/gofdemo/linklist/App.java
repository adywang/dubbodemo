package com.gofdemo.linklist;


public class App {
    public static void main(String[] args) {
        HeroNode sj=new HeroNode(1,"宋江","及时雨");
        HeroNode wy=new HeroNode(2,"吴用","智多星");
        HeroNode ljy=new HeroNode(3,"卢俊义","玉麒麟");
        HeroNode ryl=new HeroNode(4,"公孙胜","入云龙");
        MySingleLinkList linkList=new MySingleLinkList();
        linkList.add(sj);
        linkList.add(wy);
        linkList.add(ljy);
        linkList.add(ryl);
        linkList.showList();

//        linkList.del(3);
        linkList.update(new HeroNode(2,"wy","wy"));
        linkList.showList();
    }
}
