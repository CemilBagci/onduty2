package com.project.yasar.onduty.onduty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/index2")
    public String index2(){
        return "index2";
    }
}
