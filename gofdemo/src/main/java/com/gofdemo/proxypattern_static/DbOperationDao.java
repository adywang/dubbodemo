package com.gofdemo.proxypattern_static;

import java.util.List;
import java.util.Map;

public interface DbOperationDao {
    void insert();

    void update();

    void delete();

    List<Map> select();
}
