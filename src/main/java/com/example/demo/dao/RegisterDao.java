package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterDao {
    @Select("select count(*) from register where name = #{name} and psw = #{psw}")
    int login(@Param("name") String name , @Param("psw") String psw);
}
