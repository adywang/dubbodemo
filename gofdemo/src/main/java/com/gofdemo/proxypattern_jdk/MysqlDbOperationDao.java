package com.gofdemo.proxypattern_jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MysqlDbOperationDao implements DbOperationDao {
    @Override
    public void insert() {
        System.out.println("插入数据");
    }

    @Override
    public void update() {
        System.out.println("更新数据");
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
    }

    @Override
    public List<Map> select() {
        System.out.println("查询数据");
        return  new ArrayList<>();
    }
}
