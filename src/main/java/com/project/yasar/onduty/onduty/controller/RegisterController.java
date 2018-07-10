package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.service.DepartmentService;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.RoleService;
import com.project.yasar.onduty.onduty.service.UserService;
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
        mav.addObject("users", userService.findAll());
        mav.addObject("departments",departmentService.findAll());
        mav.addObject("contentForm", "layouts/register");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createUser(User user, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView(new RedirectView("/register", true));
        Role roleUser = roleService.findRoleByRoleNameEquals("ROLE_USER");
        user.setRoles(new ArrayList<>(Arrays.asList(roleUser)));
        user = userService.createUser(user);
        userService.createUser(user);
        Personal personal = new Personal(user, new ArrayList<>(), new HashSet<>());
        personalService.createPersonal(personal);
        return mav;
    }

    @RequestMapping(value = "/register/{id}/updateForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateRegisterForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("layouts/registerForm");
        User user = userService.get(id);
        mav.addObject("user", user);
        mav.addObject("user", userService.findAll());

        return mav;
    }
    @RequestMapping(value = "/register/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);

    }

}
