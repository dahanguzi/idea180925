package com.atguigu.testidea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestIdea {

    @ResponseBody
    @GetMapping("/hello")
    public String test(){
        return "hello idea!";
    }
}
