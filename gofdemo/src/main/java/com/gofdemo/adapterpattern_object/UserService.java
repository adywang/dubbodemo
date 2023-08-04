package com.gofdemo.adapterpattern_object;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map findById();
    List<Map> findList();
}
