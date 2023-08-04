package com.gofdemo.templatepattern;

public abstract class RegisterTemplate {
    public final boolean register(String name, String phone) throws Exception {
        checkUserName(name);
        CheckPhone(phone);
        insertData();
        if (isAutoLogin()) {
            autoLogin();
        }else{
            System.out.println("用户注册成功，请登录");
        }
        return true;
    }

    protected abstract boolean checkUserName(String name) throws Exception;

    protected abstract boolean CheckPhone(String phone) throws Exception;

    protected abstract boolean insertData() throws Exception;

    protected abstract void autoLogin();

    protected boolean isAutoLogin() {
        return true;
    }

}
