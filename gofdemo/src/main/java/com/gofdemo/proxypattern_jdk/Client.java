package com.gofdemo.proxypattern_jdk;

public class Client {
    public static void main(String[] args) {
        DbOperationDao target=new MysqlDbOperationDao();
        ProxyFactory proxy = new ProxyFactory( target);
        Object proxyInstance = proxy.getProxyInstance();

       DbOperationDao _proxyInstance= (DbOperationDao) proxyInstance;
       _proxyInstance.insert();
        System.out.println("<---------->");
       _proxyInstance.delete();
    }
}
