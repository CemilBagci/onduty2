package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.ContextUtil;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;

import com.project.yasar.onduty.onduty.service.ProjectService;
import com.project.yasar.onduty.onduty.service.PersonalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        mav.addObject("project",new Project());
        mav.addObject("projects", personalService.getCurrentPersonal().getProjects());
        mav.addObject("contentForm", "layouts/projects");
        return mav;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public ModelAndView createProject( Project project, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView(new RedirectView("/projects", true));
        project = projectService.createProject(project);
        Personal currentPersonal = personalService.getCurrentPersonal();
        currentPersonal.getProjects().add(project);
        personalService.updatePersonal(currentPersonal);
        return mav;
    }
}
    

