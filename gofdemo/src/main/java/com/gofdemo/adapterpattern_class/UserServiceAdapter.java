package com.gofdemo.adapterpattern_class;

public class UserServiceAdapter extends UserServiceImpl implements TargetUserService {


    @Override
    public String findByStrId() {
        return super.findById().toString();
    }

    @Override
    public String findStrList() {
        return super.findList().toString();
    }
}
