package com.gofdemo.uml.generation;

import java.util.List;
import java.util.Map;

public abstract class CurdDao {
    public abstract List<Map> getList();

    public abstract void add(Object obj);

    public abstract void update(String key, Object obj);

    public abstract void delete(String key);
}
