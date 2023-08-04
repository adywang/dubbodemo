package com.gofdemo.builderpattern.msg;

public abstract class IotMsgBuilder {
    protected IotMsg iotMsg = new IotMsg();

    public IotMsg getIotMsg() {
        return iotMsg;
    }

    public abstract IotMsgBuilder buildStart();

    public abstract IotMsgBuilder buildEnd();

    public abstract IotMsgBuilder buildData(String data);

    public abstract IotMsgBuilder buildMsgType();

    public abstract IotMsgBuilder buildLength() ;
    public abstract  String build();

}
