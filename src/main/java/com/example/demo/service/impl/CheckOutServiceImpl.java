package com.example.demo.service.impl;

import com.example.demo.dao.CheckOutDao;
import com.example.demo.domain.CheckOut;
import com.example.demo.domain.Customer;
import com.example.demo.service.CheckOutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Resource
    private CheckOutDao checkOutDao;

    @Override
    public List<CheckOut> selectAll() {
        List<CheckOut> checkOutList = checkOutDao.selectAll();
        return checkOutList;
    }

    @Override
    public boolean deleteByid(Integer id) {
        if (checkOutDao.deleteByid(id) > 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean addCheckOut(CheckOut checkOut) {
        if (checkOutDao.addCheckOut(checkOut) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<CheckOut> selectByName(String name) {
        List<CheckOut> checkOutList = checkOutDao.selectByName(name);
        return checkOutList;
    }

    @Override
    public boolean updateByCheckout(CheckOut checkOut) {
        if (checkOutDao.updateByCheckOut(checkOut) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public CheckOut selectById(Integer id) {
        CheckOut checkOut = checkOutDao.selectById(id);
        return checkOut;
    }
}
