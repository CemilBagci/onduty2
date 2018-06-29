package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.ContextUtil;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;

import com.project.yasar.onduty.onduty.service.ProjectService;
import com.project.yasar.onduty.onduty.service.PersonalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {
	
	@Autowired
	PersonalService personalService;
	
    @Autowired
    ProjectService projectService;
    
    @RequestMapping(value ={ "/projects"}, method = RequestMethod.GET)
    public ModelAndView showPersonal() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("projects", personalService.getCurrentPersonal().getProjects());
        mav.addObject("contentForm", "layouts/projects");
        return mav;
    }

    
/*
   @RequestMapping(value = "projects",method = RequestMethod.GET)
    public ModelAndView showProjects(){
        ModelAndView mav = new ModelAndView("main");
        Project  projects = projectService.findProjectByProjectNameEquals(name);
        projects.getTasks();
        mav.addObject("project",projects);
        mav.addObject("task", tasks);


        mav.addObject("contentForm","layouts/projects");
        return mav;
    }



    @RequestMapping(value = "projects/{name}",method = RequestMethod.GET)
        public ModelAndView showProjects(@PathVariable("name") String name){
            ModelAndView mav = new ModelAndView("main");
            Project  projects = projectService.findProjectByProjectNameEquals(name);
            Task task = taskService.findTaskByProjects((List<Project>) projects);
            mav.addObject("task", task);
            mav.addObject("project",  projects);
            mav.addObject("contentForm","layouts/projects");
            return mav;
        }
        
        */
    }

