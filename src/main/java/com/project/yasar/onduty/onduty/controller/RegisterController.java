package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.service.DepartmentService;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.RoleService;
import com.project.yasar.onduty.onduty.service.UserService;
import com.project.yasar.onduty.onduty.viewmodel.UserRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PersonalService personalService;
    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("user", new User());
        mav.addObject("userRegister", new UserRegister());
        mav.addObject("users", userService.findAll());
        mav.addObject("departments",departmentService.findAll());
        mav.addObject("contentForm", "layouts/register");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createUser(UserRegister userRegister, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView(new RedirectView("/register", true));
        userService.saveUser(userRegister);
        return mav;
    }

    @RequestMapping(value = "/register/{id}/updateForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateRegisterForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("layouts/registerForm");
        User user = userService.get(id);
        UserRegister userRegister = new UserRegister();
        Personal personalByUser = personalService.findPersonalByUser(user);
        userRegister.setDepartments(personalByUser.getDepartments());
        userRegister.setEmail(user.getEmail());
        userRegister.setName(user.getName());
        userRegister.setPassword(user.getPassword());
        userRegister.setId(user.getId());
        userRegister.setState(user.getState());
        userRegister.setSurname(user.getSurname());
        userRegister.setUsername(user.getUsername());

        mav.addObject("userRegister", userRegister);
        //mav.addObject("user", userService.findAll());
        mav.addObject("departments",departmentService.findAll());

        return mav;
    }
    @RequestMapping(value = "/register/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id); 
        

    }

}
