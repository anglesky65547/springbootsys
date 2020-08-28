package com.example.demo.controller;

import com.example.demo.domain.Worker;
import com.example.demo.service.WorkerService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkerController {
    @Resource
    private WorkerService workerService;
    /**
     * 显示所有员工信息
     * @param model
     * @return
     */
    @GetMapping("worker")
    public String worker(Model model){
        List<Worker> workerList = workerService.selectAll();
        model.addAttribute("list",workerList);
        return "worker";
    }

    /**
     * 显示新增员工页面
     * @return
     */
    @GetMapping("add")
    public String add(){
        return "add";
    }

    @DeleteMapping("del/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id){
        if (workerService.deleteByid(id)){
            return "success";
        }
        else {
            return "fail";
        }
    }


    @PostMapping("search")
    public String serachByName(@RequestParam String worker,Model model){
        List<Worker> workerList = new ArrayList<>();
      if (worker == ""){
          workerList = workerService.selectAll();
          model.addAttribute("list",workerList);
          return "worker";
      }else {
          workerList = workerService.selectByName(worker);
          model.addAttribute("list", workerList);
          return "worker";
      }
    }

    /**
     * 新增员工信息保存
     * @param worker
     */
    @PostMapping("newworker")
    public String addWorker(Worker worker){
        workerService.addWorker(worker);

        return "redirect:worker";

    }

    //根据id获取要修改的数据
    @GetMapping("update/{id}")
    public String update(@PathVariable Integer id,Model model){
        Worker worker = workerService.selectById(id);
        model.addAttribute("worker",worker);
        return "update";
    }

    /**
     * 保存修改的数据
     * @param worker
     * @return
     */
    @PutMapping("saveupdate")
    public String saveUpdate(Worker worker){
        if (workerService.updateByWorker(worker)) {
            return "redirect:worker";
        }else {
            return "first";
        }
    }

}
