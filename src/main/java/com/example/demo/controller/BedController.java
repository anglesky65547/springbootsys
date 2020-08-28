package com.example.demo.controller;

import com.example.demo.dao.CustomerNameDao;
import com.example.demo.domain.Bed;
import com.example.demo.domain.CustomerName;
import com.example.demo.service.BedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BedController {

    @Resource
    private BedService bedService;
    @Resource
    private CustomerNameDao customerNameDao;

    @GetMapping("bed")
    public String showBed(Model model){
        List<Bed> bedList = bedService.selectAll();
        model.addAttribute("bed",bedList);
        return "bed";
    }

    @PostMapping("searchbybed")
    public String search(@RequestParam String name,Model model){
        List<Bed> bedList = new ArrayList<>();
        if("" == name){
            bedList = bedService.selectAll();
            model.addAttribute("bed",bedList);
            return "bed";
        }
        else {
            bedList = bedService.selectByName(name);
            model.addAttribute("bed",bedList);
            return "bed";
        }
    }

    @GetMapping("addbed")
    public String addBed(Model model){
        List<CustomerName> names = customerNameDao.selectCustomerName();
        model.addAttribute("name",names);
        return "addbed";
    }

    @PutMapping("newbed")
    public String newbed(Bed bed){
        if (bedService.addBed(bed)){
            return "redirect:bed";
        }else {
            return "fail";
        }
    }

    @DeleteMapping("delbed/{id}")
    @ResponseBody
    public String delbed(@PathVariable Integer id){
        if (bedService.deleteByid(id)){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("updatebed/{id}")
    public String updateBed(@PathVariable Integer id,Model model){
        Bed bed = bedService.selectById(id);
        model.addAttribute("bed",bed);
        List<CustomerName> names = customerNameDao.selectCustomerName();
        model.addAttribute("name",names);
        return "updatebed";
    }
    @PutMapping("newbed1")
    public String updateBed(Bed bed){
        bedService.updateByBed(bed);
        return "redirect:bed";
    }
}
