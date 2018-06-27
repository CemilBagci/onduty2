package com.project.yasar.onduty.onduty;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    PersonalService personalService;

    @ModelAttribute("currentPersonal")
    public Personal getCurrentPersonel() {
        return personalService.getCurrentPersonal();
    }
}