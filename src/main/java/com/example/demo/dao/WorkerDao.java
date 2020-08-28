package com.example.demo.dao;

import com.example.demo.domain.Worker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  WorkerDao {
    //查询所有信息
    @Select("select * from worker order by id asc")
    public List<Worker> selectAll();

    //根据姓名查询信息
    @Select("select * from worker where worker = #{worker}")
    public List<Worker> selectByName(String worker);

    //根据ID查询信息
    @Select("select * from worker where id = #{id}")
    public Worker selectById(Integer id);

    //添加信息
    @Insert("insert into worker(workerid,worker,sex,age,type,entrydate,post,title,status,introduction,note) values(#{workerid},#{worker},#{sex},#{age},#{type},#{entrydate},#{post},#{title},#{status},#{introduction},#{note})")
    public int addWorker(Worker worker);

    //删除信息
    @Delete("delete from worker where id = #{id}")
    public int deleteByid(Integer id);

    //修改信息
    @UpdateProvider(type = CustomerSQLProvider.class ,method = "updateWorker")
    public int updateByWork(Worker worker);
}
