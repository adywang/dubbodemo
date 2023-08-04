package com.example.shardingjdbcdemo01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    @Select("select *from t_order where order_id=#{id}")
    List<Map> selectList(int id);

    @Insert("insert into t_order (name)values('ggg')")
    void  insert();

    @Select("select * from user")
    void userInfo();
    @Select("select * from t_address")
    List<Map> getAddress(int id);
}
