package com.example.demo.service;

import com.example.demo.domain.Worker;

import java.util.List;

public interface WorkerService {
    public List<Worker> selectAll();
    public List<Worker> selectByName(String name);
    public Worker selectById(Integer id);
    public boolean addWorker(Worker worker);
    public boolean deleteByid(Integer id);
    public boolean updateByWorker(Worker worker);


}
