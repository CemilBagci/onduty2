package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Credential;
import com.project.yasar.onduty.onduty.service.CredentialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;

@Controller
public class LoginController {
    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @Autowired
    CredentialService credentialService;
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Credential credential = credentialService.findByUserUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + credential.getUsername() + " " + credential.getPassword() + " ("  + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/index2");
        return modelAndView;
    }

}
