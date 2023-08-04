package com.gofdemo.proxypattern_jdk;

import java.util.List;
import java.util.Map;

public interface DbOperationDao {
    void insert();

    void update();

    void delete();

    List<Map> select();
}
