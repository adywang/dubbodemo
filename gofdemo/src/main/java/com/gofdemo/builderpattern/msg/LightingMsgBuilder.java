package com.gofdemo.builderpattern.msg;

public class LightingMsgBuilder extends IotMsgBuilder {

    @Override
    public IotMsgBuilder buildStart() {
        iotMsg.setStart("68");
        return this;
    }

    @Override
    public IotMsgBuilder buildEnd() {
        iotMsg.setEnd("");
        return this;
    }

    @Override
    public IotMsgBuilder buildData(String data) {
        iotMsg.setData(data);
        return this;
    }

    @Override
    public IotMsgBuilder buildMsgType() {
        iotMsg.setDataType("hex");
        return this;
    }

    @Override
    public IotMsgBuilder buildLength()  {
        if (iotMsg.getData() == null && iotMsg.getData().length() == 0) {
            System.out.println("请设置数据");
        }
        iotMsg.setLength(iotMsg.getData().length());
        return this;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(iotMsg.getStart());
//        sb.append(iotMsg.getLength());
        sb.append(iotMsg.getData());
        sb.append(iotMsg.getEnd());
        return sb.toString();
    }
}
