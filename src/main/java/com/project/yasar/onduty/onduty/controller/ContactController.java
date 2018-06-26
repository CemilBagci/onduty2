package com.project.yasar.onduty.onduty.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContactController {

	        
	 @RequestMapping(value={ "/contact"}, method = RequestMethod.GET)
	    public ModelAndView contact(){
		 ModelAndView mav = new ModelAndView("main"); 
	        mav.addObject("contentForm","layouts/contact");
	        return mav;
	 }
    




    }
   
