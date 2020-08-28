package com.example.demo.dao;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Worker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {
    //查询所有信息
    @Select("select * from checkin order by customerid asc")
    public List<Customer> selectAll();

    //根据姓名查询信息
    @Select("select * from checkin where name = #{name}")
    public List<Customer> selectByName(String name);

    //根据ID查询信息
    @Select("select * from checkin where customerid = #{id}")
    public Customer selectById(Integer id);

    //添加信息
    @Insert("insert into checkin(customerid,name,age,sex,idnumber,roomid,floatid,filesid,oldmantype,checkindata,servicematurity,phonenumber,height,maritalstatus,weight,bloodtype,image,worker,note) " +
            "values(#{customerid},#{name},#{age},#{sex},#{idnumber},#{roomid},#{floatid},#{filesid},#{oldmantype},#{checkindata},#{servicematurity},#{phonenumber},#{height},#{maritalstatus},#{weight},#{bloodtype},#{image},#{worker},#{note})")
    public int addCustomer(Customer customer );

    //删除信息
    @Delete("delete from checkin where customerid = #{id}")
    public int deleteByid(Integer id);

    //修改信息
    @UpdateProvider(type = CustomerSQLProvider.class ,method = "updateCustomer")
    public int updateByCustomer(Customer customer);
}
