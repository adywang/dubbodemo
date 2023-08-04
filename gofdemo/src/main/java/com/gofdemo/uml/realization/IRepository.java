package com.gofdemo.uml.realization;

import java.util.List;
import java.util.Map;

public interface IRepository {
    List<Map> getList();

    void add(Object obj);

    void update(String key, Object obj);

    void delete(String key);
}
