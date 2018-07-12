
package com.project.yasar.onduty.onduty.controller;


import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.TaskMessage;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.ProjectService;
import com.project.yasar.onduty.onduty.service.TaskMessageService;
import com.project.yasar.onduty.onduty.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private TaskMessageService taskMessageService;

    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.GET)
    public ModelAndView showTask(@RequestParam Long id) {
        Task task = taskService.get(id);
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("task", task);

        mav.addObject("contentForm", "layouts/tasks");
        return mav;
    }

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public ModelAndView showTasks(@RequestParam(value = "show",required = false) String show) {
        ModelAndView mav = new ModelAndView("main");
        Personal currentPersonal = personalService.getCurrentPersonal();
        List<Project> projectsByPersonalsContains = projectService.findProjectsByPersonalsContains(currentPersonal);
        LinkedList<Task> tasks;
        if ("assigned".equals(show)) {
            tasks = taskService.findTaskByAssignerPersonalEquals(currentPersonal);
        } else {
            tasks =
                    projectsByPersonalsContains.stream()
                            .map(Project::getTasks)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toCollection(LinkedList::new));
        }

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


    @RequestMapping(value = "/task/{id}/description", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showDescription(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("layouts/taskDescription");
        Task task = taskService.get(id);
        mav.addObject("task", task);
        return mav;
    }

    @RequestMapping(value = "/task/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteTask(@PathVariable("id") Long id) {
        return taskService.delete(id);
    }


    @RequestMapping(value = "/task/{id}/showDetail", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("layouts/taskDetail");
        Task task = taskService.get(id);
        List<TaskMessage> taskMessages = task.getTaskMessages();
        mav.addObject("taskMessages", taskMessages);
        mav.addObject("task", task);
        mav.addObject("personals", personalService.findAll());
        mav.addObject("projects", projectService.findAll());
        return mav;
    }

    @RequestMapping(value = "/messages/task/{taskId}", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView listMessageList(@PathVariable("taskId") Long taskId, @RequestParam("content") String content) {
        Personal currentPersonal = personalService.getCurrentPersonal();
        Task task = taskService.get(taskId);
        TaskMessage taskMessage = new TaskMessage(content,new Date(), currentPersonal);
        task.getTaskMessages().add(taskMessage);
        task =taskService.createTask(task);
        ModelAndView mav = new ModelAndView("layouts/messageList");
        mav.addObject("taskMessages",task.getTaskMessages());
        return mav;
    }
}


