package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = {"","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("left")
    public String left() {
        return "left";
    }
    @GetMapping("content")
    public String content(){
        return "content";
    }

}
