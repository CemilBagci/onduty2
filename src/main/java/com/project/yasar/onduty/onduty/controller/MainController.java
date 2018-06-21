package com.project.yasar.onduty.onduty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/services")
    public String services(){
        return "services";
    }
}
