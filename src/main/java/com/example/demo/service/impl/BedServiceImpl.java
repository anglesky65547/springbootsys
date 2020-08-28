package com.example.demo.service.impl;

import com.example.demo.dao.BedDao;
import com.example.demo.domain.Bed;
import com.example.demo.service.BedService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BedServiceImpl implements BedService {
    @Resource
    private BedDao bedDao;
    @Override
    public List<Bed> selectAll() {
        List<Bed> bedList = bedDao.selectAll();
        return bedList;
    }

    @Override
    public List<Bed> selectByName(String name) {
        List<Bed> bedList = bedDao.selectByName(name);
        return bedList;
    }

    @Override
    public Bed selectById(Integer id) {
        Bed bed = bedDao.selectById(id);
        return bed;
    }

    @Override
    public boolean addBed(Bed bed) {
        if (bedDao.addBed(bed) > 0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteByid(Integer id) {
        if (bedDao.deleteByid(id) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByBed(Bed bed) {
        if(bedDao.updateByBed(bed) > 0){
            return true;
        }
        return false;
    }
}
