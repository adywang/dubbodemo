package com.gofdemo.adapterpattern_class;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map findById();
    List<Map> findList();
}
