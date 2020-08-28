package com.example.demo.dao;

import com.example.demo.domain.CheckOut;
import com.example.demo.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CheckOutDao {
    //查询所有信息
    @Select("select * from checkout order by id asc")
    public List<CheckOut> selectAll();

    //根据姓名查询信息
    @Select("select * from checkout where customername = #{name}")
    public List<CheckOut> selectByName(String name);

    //根据ID查询信息
    @Select("select * from checkout where id = #{id}")
    public CheckOut selectById(Integer id);

    //添加信息
    @Insert("insert into checkout(customername,type,reason,checkoutdata,applicationdata,auditMind,auditdata,worker,auditstatus,note) " +
            "values(#{customername},#{type},#{reason},#{checkoutdata},#{applicationdata},#{auditMind},#{auditdata},#{worker},#{auditstatus},#{note})")
    public int addCheckOut(CheckOut checkOut );

    //删除信息
    @Delete("delete from checkout where id = #{id}")
    public int deleteByid(Integer id);

    //修改信息
    @UpdateProvider(type = CustomerSQLProvider.class ,method = "updateCheckout")
    public int updateByCheckOut(CheckOut checkOut);
}
