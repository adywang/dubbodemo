package com.example.shardingjdbcdemo01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    @Select("select id,name from t_user where id=#{id}")
    List<Map> selectList(int id);

    @Insert("insert into t_user (name,id)values(#{name},#{id})")
    void  insert(String name,int id);

    @Select("select * from t_user")
    void userInfo();

}
