package com.project.yasar.onduty.onduty.controller;


import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.ProjectService;
import com.project.yasar.onduty.onduty.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class TaskController {
    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;
    
    @Autowired
    PersonalService personalService;
    
   
    @RequestMapping(value = { "/tasks"}, method = RequestMethod.GET)
    public ModelAndView showTasks() {
        ModelAndView mav = new ModelAndView("main");
        
        List<Task> tasks = personalService.getCurrentPersonal()
        		.getProjects()
        		.stream()
        		.map(p -> p.getTasks())
        		.flatMap(t -> t.stream())
        		.collect(Collectors.toList());
        
        mav.addObject("tasks", tasks);
        mav.addObject("contentForm", "layouts/tasks");
        return mav;
    }

}


