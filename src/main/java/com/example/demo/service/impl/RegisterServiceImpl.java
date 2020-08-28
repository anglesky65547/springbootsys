package com.example.demo.service.impl;

import com.example.demo.dao.RegisterDao;
import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterDao registerDao;
    @Override
    public boolean login(String name, String psw) {
        if ( registerDao.login(name, psw) == 1 ){
            return true;
        }else {
            return false;
        }
    }
}
