package com.example.demo.dao;

import com.example.demo.domain.CustomerName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerNameDao {

    @Select("select name from checkin")
    public List<CustomerName> selectCustomerName();
}
