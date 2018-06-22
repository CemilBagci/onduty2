package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @Autowired
    UserService userService;
    @RequestMapping(value = "personal/{username}",method = RequestMethod.GET)
    public ModelAndView showPersonal(@PathVariable("username") String username){
        ModelAndView mav = new ModelAndView("main");
        User user = userService.findUserByUsernameEquals(username);
        Personal personal = personalService.findPersonalByUser(user);
        mav.addObject("personal",personal);
        mav.addObject("contentForm","layouts/personalForm");
        return mav;
    }
}
