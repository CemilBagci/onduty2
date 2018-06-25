package com.project.yasar.onduty.onduty.controller;

import com.project.yasar.onduty.onduty.ContextUtil;
import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.service.GroupService;
import com.project.yasar.onduty.onduty.service.PersonalService;
import com.project.yasar.onduty.onduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GroupController {
    @Autowired
    GroupService groupService;

    @Autowired
    PersonalService personalService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "groups",method = RequestMethod.GET)
    public ModelAndView showGroups(){
        ModelAndView mav = new ModelAndView("main");
        User user = userService.findUserByUsernameEquals(ContextUtil.getUsername());
        Personal personal = personalService.findPersonalByUser(user);
        mav.addObject("groups",  personal.getGroups());

        mav.addObject("personal",personal);
        mav.addObject("user", user);
        mav.addObject("contentForm","layouts/groups");
        return mav;
    }



    @RequestMapping(value = "groups/{groupName}",method = RequestMethod.GET)
        public ModelAndView showGroup(@PathVariable("groupName") String groupName){
            ModelAndView mav = new ModelAndView("main");
            Group  groups = groupService.findGroupByGroupNameEquals(groupName);
            Personal personal = personalService.findPersonalByGroups((List<Group>) groups);
            mav.addObject("personal",personal);
            mav.addObject("group",  groups);
            mav.addObject("contentForm","layouts/groupForm");
            return mav;
        }
    }

