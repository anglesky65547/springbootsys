package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDao;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Worker;
import com.example.demo.service.CustomerService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;


import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = customerDao.selectAll();
        return customerList;
    }

    @Override
    public boolean deleteByid(Integer id) {
       if(customerDao.deleteByid(id) >0){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customerDao.addCustomer(customer) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Customer> selectByName(String name) {
        List<Customer> customerList = customerDao.selectByName(name);
        return customerList;
    }

    @Override
    public Customer selectById(Integer id) {
        Customer customer = customerDao.selectById(id);
        return customer;
    }

    @Override
    public boolean updateByCustomer(Customer customer) {
        if (customerDao.updateByCustomer(customer) > 0){
            return true;
        }
        return false;
    }

}
