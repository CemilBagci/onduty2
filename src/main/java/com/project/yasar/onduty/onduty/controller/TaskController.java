package com.project.yasar.onduty.onduty.controller;


import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.ProjectService;
import com.project.yasar.onduty.onduty.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {
    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @Autowired
    PersonalService personalService;

    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.GET)
    public ModelAndView showTask(@RequestParam Long id) {
        Task task = taskService.get(id);
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("task", task);
        mav.addObject("contentForm", "layouts/tasks");
        return mav;
    }

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public ModelAndView showTasks() {
        ModelAndView mav = new ModelAndView("main");

        List<Task> tasks = personalService.getCurrentPersonal()
                .getProjects()
                .stream()
                .map(Project::getTasks)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        mav.addObject("tasks", tasks);
        mav.addObject("task", new Task());
        mav.addObject("personals", personalService.findAll());
        mav.addObject("projects", projectService.findAll());

        mav.addObject("contentForm", "layouts/tasks");
        return mav;
    }


    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ModelAndView createTask(Task task, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView(new RedirectView("/tasks", true));
        task.setAssignerPersonal(personalService.getCurrentPersonal());
        task = taskService.createTask(task);
        return mav;
    }

    @RequestMapping(value = "/task/{id}/updateForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateTaskForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("layouts/taskForm");
        Task task = taskService.get(id);
        mav.addObject("task", task);
        mav.addObject("personals", personalService.findAll());
        mav.addObject("projects", projectService.findAll());
        return mav;
    }
}


