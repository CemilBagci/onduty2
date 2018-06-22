package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    private static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("contentForm", "layouts/indexForm");
        User user = userService.findUserByUsernameEquals(getUsername());
        mav.addObject("user", user);
        return mav;
    }


    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/task")
    public String task() {
        return "task";
    }

    @RequestMapping("/group")
    public String group() {
        return "group";
    }

    @RequestMapping("/message")
    public String message() {
        return "message";
    }
}
