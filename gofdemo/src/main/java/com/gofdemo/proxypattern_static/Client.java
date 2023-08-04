package com.gofdemo.proxypattern_static;

public class Client {
    public static void main(String[] args) {
        DbOperationDao dbOperationDao=new MysqlDbOperationDao();
        DbOperationDao proxy=new DbOperationProxy(dbOperationDao);
        proxy.insert();
        proxy.update();
    }
}
