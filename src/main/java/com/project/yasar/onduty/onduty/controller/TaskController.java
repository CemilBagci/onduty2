package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.TaskService;
import com.project.yasar.onduty.onduty.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class TaskController {
    @Autowired
    PersonalService personalService;

    @Autowired
    TaskService taskService;


    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public ModelAndView showPersonal() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("tasks", personalService.getCurrentPersonal().getTasks());
        mav.addObject("contentForm", "layouts/tasks");
        return mav;
    }

}
