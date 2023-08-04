package com.gofdemo.builderpattern.msg;

public class Main {
    public static void main(String[] args) {
        MsgCreator msgCreator=new MsgCreator(new LightingMsgBuilder());
       String msg= msgCreator.generatorMsg
                (" 14 25 36 14 75 36 95 AB 63 95");
        System.out.println(msg);

        MsgCreator  msgCreator1=new MsgCreator(new Env212MsgBuilder());
        String  msg1= msgCreator1.generatorMsg
                ("QN=20210707235945933;ST=91;CN=9011;PW=123456;MN=MK130581V00470;Flag=4;CP=&&QnRtn=5&&B981");
        System.out.println(msg1);
    }
}
