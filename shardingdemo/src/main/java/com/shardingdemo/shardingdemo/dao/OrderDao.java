package com.shardingdemo.shardingdemo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    @Select("select * from t_order where order_id=#{id}")
    List<Map> getOne(int id);
    @Insert("insert into t_order(name)values('ffff')")
    void  insert();
}
