package com.example.demo.dao;

import com.example.demo.domain.Bed;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BedDao {
    //查询所有信息
    @Select("select * from bed order by bedid asc")
    public List<Bed> selectAll();

    //根据姓名查询信息
    @Select("select * from bed where customername = #{name}")
    public List<Bed> selectByName(String name);

    //根据ID查询信息
    @Select("select * from bed where bedid = #{id}")
    public Bed selectById(Integer id);

    //添加信息
    @Insert("insert into bed(bedid,customername,startdate,enddate,info) " +
            "values(#{bedid},#{customername},#{startdate},#{enddate},#{info})")
    public int addBed(Bed bed );

    //删除信息
    @Delete("delete from bed where bedid = #{id}")
    public int deleteByid(Integer id);

    //修改信息
    @UpdateProvider(type = CustomerSQLProvider.class ,method = "updateBed")
    public int updateByBed(Bed bed);
}
