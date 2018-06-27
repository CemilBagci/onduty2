package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.ContextUtil;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserService userService;



    @RequestMapping({"/", "/index"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("contentForm", "layouts/indexForm");

//        mav.addObject("user", user);
        return mav;
    }


    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/task")
    public String task() {
        return "task";
    }

    @RequestMapping("/group")
    public String group() {
        return "group";
    }

    @RequestMapping("/message")
    public String message() {
        return "message";
    }
}
