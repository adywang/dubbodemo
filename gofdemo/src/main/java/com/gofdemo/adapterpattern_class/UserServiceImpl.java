package com.gofdemo.adapterpattern_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Override
    public Map findById() {
        Map map = new HashMap();
        map.put("userid", 1111);
        map.put("userName", "james");
        map.put("age", 20);
        return map;
    }

    @Override
    public List<Map> findList() {
        List<Map> maps = new ArrayList<>();
        Map map = new HashMap();
        map.put("userid", 1111);
        map.put("userName", "james");
        map.put("age", 20);
        maps.add(map);
        map=new HashMap();
        map.put("userid", 2222);
        map.put("userName", "tom");
        map.put("age", 19);
        maps.add(map);
        return maps;
    }
}
