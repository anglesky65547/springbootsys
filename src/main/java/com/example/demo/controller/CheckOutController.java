package com.example.demo.controller;

import com.example.demo.dao.CustomerNameDao;
import com.example.demo.domain.CheckOut;
import com.example.demo.domain.CustomerName;
import com.example.demo.service.CheckOutService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckOutController {
    @Resource
    private CheckOutService checkOutService;

    @Resource
    private CustomerNameDao customerNameDao;

    @GetMapping("checkout")
    public String showAll(Model model){
        List<CheckOut> checkOutList = checkOutService.selectAll();
        model.addAttribute("checkout",checkOutList);
        return "checkout";
    }

    @GetMapping("addCheckout")
    public String addCheckout(Model model){
        List<CustomerName> customerNames = customerNameDao.selectCustomerName();
        model.addAttribute("name",customerNames);
        return "addCheckout";
    }

    @PutMapping("newcheckout")
    public String newcheckout(CheckOut check){
        if (checkOutService.addCheckOut(check)){
            return "redirect:checkout";
        }
        return "fail";
    }

    @DeleteMapping("delcheckout/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id){
        if (checkOutService.deleteByid(id)){
            return "success";
        }
        else {
            return "fail";
        }
    }

    @GetMapping("updatecheckout/{id}")
    public String updatecheckout(@PathVariable Integer id,Model model){
        CheckOut check = checkOutService.selectById(id);
        List<CustomerName> customerNames = customerNameDao.selectCustomerName();
        model.addAttribute("checkout",check);
        model.addAttribute("name",customerNames);
        return "updatecheckout";
    }
    @PutMapping("savecheckout")
    public String savecheckout(CheckOut check){
        checkOutService.updateByCheckout(check);
        return "redirect:checkout";
    }

    @PostMapping("searchbycheckout")
    public String searchbycheckout(@RequestParam String name,Model model){
        List<CheckOut> checkOutList = new ArrayList<>();
        if(""== name){
            checkOutList = checkOutService.selectAll();
            model.addAttribute("checkout",checkOutList);
            return "checkout";
        }else {
            checkOutList = checkOutService.selectByName(name);
            model.addAttribute("checkout",checkOutList);
            return "checkout";
        }
    }
}
