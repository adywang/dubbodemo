package com.gofdemo.builderpattern.msg;

public class MsgCreator {
    private IotMsgBuilder msgBuilder;

    public MsgCreator(IotMsgBuilder builder) {
        this.msgBuilder = builder;
    }

    public String generatorMsg(String data) {
        return msgBuilder.buildStart().buildData(data).buildEnd().buildLength().buildMsgType().build();
    }
}
