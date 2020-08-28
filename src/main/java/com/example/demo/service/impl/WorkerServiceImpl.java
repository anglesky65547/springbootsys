package com.example.demo.service.impl;

import com.example.demo.dao.WorkerDao;
import com.example.demo.domain.Worker;
import com.example.demo.service.WorkerService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class WorkerServiceImpl implements WorkerService {
    @Resource
    private WorkerDao workerDao;
    @Override
    public List<Worker> selectAll() {
        List<Worker> workerList = workerDao.selectAll();
        return workerList;
    }

    @Override
    public List<Worker> selectByName(String name) {
        return workerDao.selectByName(name);
    }

    @Override
    public Worker selectById(Integer id) {
        Worker worker = workerDao.selectById(id);
        return worker;
    }

    @Override
    public boolean addWorker(Worker worker) {
        if(workerDao.addWorker(worker)>0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteByid(Integer id) {
        if (workerDao.deleteByid(id) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByWorker(Worker worker) {
        if(workerDao.updateByWork(worker) > 0){
            return true;
        }
        return false;
    }
}
