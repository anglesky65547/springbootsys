package com.example.demo.service;

import com.example.demo.domain.CheckOut;
import com.example.demo.domain.Customer;

import java.util.List;

public interface CheckOutService {
    public List<CheckOut> selectAll();
    public boolean deleteByid(Integer id);
    public boolean addCheckOut(CheckOut checkOut );
    public List<CheckOut> selectByName(String name);
    public boolean updateByCheckout(CheckOut checkOut );
    public CheckOut selectById(Integer id);
}
