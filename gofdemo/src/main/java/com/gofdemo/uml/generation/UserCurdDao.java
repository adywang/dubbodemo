package com.gofdemo.uml.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserCurdDao extends CurdDao {
    @Override
    public List<Map> getList() {
        return new ArrayList<>();
    }

    @Override
    public void add(Object obj) {
        System.out.println("add");
    }

    @Override
    public void update(String key, Object obj) {
        System.out.println("update:"+key);
    }

    @Override
    public void delete(String key) {
        System.out.println("delete:" + key);
    }
}
