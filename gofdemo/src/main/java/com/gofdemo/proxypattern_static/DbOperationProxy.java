package com.gofdemo.proxypattern_static;

import java.util.List;
import java.util.Map;

public class DbOperationProxy implements DbOperationDao{
    private  DbOperationDao dao;

    public DbOperationProxy(DbOperationDao dao) {
        this.dao = dao;
    }

    @Override
    public void insert() {
        System.out.println("开启插入事务");
        dao.insert();
        System.out.println("结束插入事务");
    }

    @Override
    public void update() {
        System.out.println("开启更新事务");
        dao.update();
        System.out.println("结束更新事务");
    }

    @Override
    public void delete() {
        System.out.println("开启删除事务");
        dao.delete();
        System.out.println("结束删除事务");
    }

    @Override
    public List<Map> select() {
        return null;
    }
}
