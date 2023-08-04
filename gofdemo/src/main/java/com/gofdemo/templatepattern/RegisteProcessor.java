package com.gofdemo.templatepattern;

public class RegisteProcessor extends RegisterTemplate {
    @Override
    public boolean checkUserName(String name) throws Exception {
        if (name == null || name.equals("tome")) {
            throw new Exception("请检查用户名");
        }
        System.out.println("用户名验证成功！！！");
        return true;
    }

    @Override
    public boolean CheckPhone(String phone) throws Exception {
        if (phone == null || phone.length() == 0) {
            throw new Exception("请检查手机号码");
        }
        System.out.println("手机号验证成功！！！");
        return true;
    }

    @Override
    public boolean insertData() throws Exception {
        System.out.println("数据插入数据库成功！！！");
        return true;
    }

    @Override
    public void autoLogin() {
        System.out.println("自动登录成功！！！");
    }

    @Override
    protected boolean isAutoLogin() {
        return false;
    }
}
