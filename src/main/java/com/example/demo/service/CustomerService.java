package com.example.demo.service;

import com.example.demo.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> selectAll();
    public boolean deleteByid(Integer id);
    public boolean addCustomer(Customer customer );
    public List<Customer> selectByName(String name);
    public boolean updateByCustomer(Customer customer);
    public Customer selectById(Integer id);
}
