package com.gofdemo.builderpattern.msg;

import javax.xml.crypto.Data;

public class Env212MsgBuilder extends IotMsgBuilder {

    @Override
    public IotMsgBuilder buildStart() {
        iotMsg.setStart("##");
        return this;
    }

    @Override
    public IotMsgBuilder buildEnd() {
        iotMsg.setEnd("\r\n");
        return this;
    }

    @Override
    public IotMsgBuilder buildData(String data) {
        iotMsg.setData(data);
        return this;
    }

    @Override
    public IotMsgBuilder buildMsgType() {
        super.getIotMsg().setDataType("string");
        return this;
    }

    @Override
    public IotMsgBuilder buildLength()  {
        if (iotMsg.getData() == null || iotMsg.getData().length() == 0) {
            System.out.println("请设置数据");
            return this ;
        }
        iotMsg.setLength(iotMsg.getData().length());
        return this;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(iotMsg.getStart());
        sb.append(String.format("%04d",iotMsg.getLength()));
        sb.append(iotMsg.getData());
        sb.append(iotMsg.getEnd());
        return sb.toString();
    }
}
