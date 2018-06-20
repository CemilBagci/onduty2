package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class TaskController {
    /*@Autowired
    private TaskService taskService;
    @RequestMapping(value={"/", "/tasks"}, method = RequestMethod.GET)
    public ModelAndView tasks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tasks");
        return modelAndView;
    }
    @RequestMapping(value={"/tasks"}, method = RequestMethod.POST)
    public ModelAndView tasks(@RequestParam String username, @RequestParam String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tasks");
        return modelAndView;
    }*/

/*
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("username", "Welcome " + user.getUsername() + " " + user.getPassword());
        User user = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("username", "Welcome " + user.getUsername() + " " + user.getPassword() + " ("  + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/index2");
        return modelAndView;
    }*/

}
