package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("personalService")
@Transactional(readOnly = true)
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    PersonalRepository personalRepository;

    @Override
    @Transactional(readOnly = false)
    public Personal createPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal updatePersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal findPersonalByUser(User user) {
        return personalRepository.findPersonalByUser(user);
    }

    @Override
    public Personal findPersonalByGroups(List<Group> groups) {
        return personalRepository.findPersonalByGroups( groups);
    }

    @Override
    public Personal findPersonalByDepartment(Department department) {
        return personalRepository.findPersonalByDepartments(department);
    }





}



