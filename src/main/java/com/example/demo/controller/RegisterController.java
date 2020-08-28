package com.example.demo.controller;

import com.example.demo.bean.ResultBean;
import com.example.demo.domain.Register;
import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Resource
    private RegisterService registerService;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("checklogin")
    @ResponseBody
    public ResultBean checkLogin(String name, String psw, HttpSession session){
        ResultBean resultBean = new ResultBean(200,"登录成功",true);
        boolean flag = registerService.login(name, psw);
        System.out.println("--------------------"+ flag);
        if(flag){
            Register register = new Register();
            register.setName(name);
            resultBean.setData(register);
            session.setAttribute("login",resultBean);
        }else {
            resultBean = new ResultBean(200,"登录失败",false);
            session.removeAttribute("login");
        }

        return resultBean;
    }

    @GetMapping("exit")
    public String exit(HttpSession session){
        session.removeAttribute("login");
        return "login";
    }
}
