package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.DepartmentService;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@SessionAttributes("currentPersonal")
public class PersonalController {
    @Autowired
    PersonalService personalService;
    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @ModelAttribute("personal")
    public Personal getCurrentPersonal() {
        return personalService.getCurrentPersonal();
    }

    @RequestMapping(value = "personal", method = RequestMethod.GET)
    public ModelAndView showPersonal() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("departments",departmentService.findAll());
        mav.addObject("contentForm", "layouts/personalForm");
        return mav;
    }

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ModelAndView updatePersonal(@ModelAttribute("personal") Personal personal) {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("personal", personalService.updatePersonal(personal));
        mav.addObject("contentForm", "layouts/personalForm");
        return mav;
    }


}

