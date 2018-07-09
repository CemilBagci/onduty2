package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("user", new User());
        mav.addObject("register", userService.findAll());
        mav.addObject("contentForm", "layouts/register");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createUser(User user, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView(new RedirectView("/register", true));
        user = userService.createUser(user);
        userService.createUser(user);
        return mav;
    }

}
