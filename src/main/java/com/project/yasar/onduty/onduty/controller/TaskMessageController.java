package com.project.yasar.onduty.onduty.controller;


import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.TaskMessage;
import com.project.yasar.onduty.onduty.service.TaskMessageService;
import com.project.yasar.onduty.onduty.service.TaskService;

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
public class TaskMessageController {                       
                                                     
	  @Autowired
	    TaskService taskMessageService;

	
	    @RequestMapping(value = "/taskMessage",method = RequestMethod.GET)
	    public ModelAndView showPersonal(@PathVariable("taskId") Long taskId){
	        ModelAndView mav = new ModelAndView("main"); 
	        Task task = taskMessageService.get(taskId);
	        mav.addObject("task",task);   
	       
	        mav.addObject("taskMessageForm","layouts/taskMessageForm");
	        return mav;
	    }

}
