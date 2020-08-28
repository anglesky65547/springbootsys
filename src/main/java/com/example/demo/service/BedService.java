package com.example.demo.service;

import com.example.demo.dao.CustomerSQLProvider;
import com.example.demo.domain.Bed;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface BedService {
    public List<Bed> selectAll();
    public List<Bed> selectByName(String name);
    public Bed selectById(Integer id);
    public boolean addBed(Bed bed );
    public boolean deleteByid(Integer id);
    public boolean updateByBed(Bed bed);
}
