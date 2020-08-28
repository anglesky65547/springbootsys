package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Worker;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("customer")
    public String showCustomer(Model model) {
        List<Customer> customerList = customerService.selectAll();
        model.addAttribute("customer",customerList);
        return "customer";
    }

    @DeleteMapping("dele/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id){
        if (customerService.deleteByid(id)){
            return "success";
        }
        else {
            return "fail";
        }
    }

    @GetMapping("addCustomer")
    public String addCustomer(){
        return "addCustomer";
    }

    @PutMapping("newCustomer")
    public String newCustomer(Customer customer){
       customerService.addCustomer(customer);
            return "redirect:customer";

    }
    @PostMapping("searchbyname")
    public String serachByName(@RequestParam String name,Model model){
        List<Customer> customerList = new ArrayList<>();
        if (name == ""){
            customerList = customerService.selectAll();
            model.addAttribute("customer",customerList);
            return "customer";
        }else {
            customerList = customerService.selectByName(name);
            model.addAttribute("customer", customerList);
            return "customer";
        }
    }

    @GetMapping("updatel/{customerid}")
    public String updateCustomer(@PathVariable Integer customerid,Model model){
        Customer customer = customerService.selectById(customerid);
        model.addAttribute("date",customer);
        return "updateCustomer";
    }

    @PutMapping("updatesave")
    public String saveUpdate(Customer customer){
        if (customerService.updateByCustomer(customer)) {
            return "redirect:customer";
        }else {
            return "first";
        }
    }


}
