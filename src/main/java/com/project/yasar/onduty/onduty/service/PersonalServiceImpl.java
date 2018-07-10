package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.ContextUtil;
import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.repository.PersonalRepository;
import com.project.yasar.onduty.onduty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service("personalService")
@Transactional(readOnly = true)
public class PersonalServiceImpl implements PersonalService {
	
    @Autowired
    PersonalRepository personalRepository;
    
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public Personal createPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    @Transactional(readOnly = false)
    public Personal updatePersonal(Personal personal) {
        userRepository.save(personal.getUser());
        return personalRepository.save(personal);
    }

    @Override
    public Personal findPersonalByUser(User user) {
        return personalRepository.findPersonalByUser(user);
    }
 /*  
    @Override
    public Personal findPersonalByGroups(List<Group> groups) {
        return personalRepository.findPersonalByGroups(groups);
    }
*/
    @Override
    public Personal getCurrentPersonal() {
        if (ContextUtil.getUsername() != null)
            return findPersonalByUser(userRepository.findUserByUsernameEquals(ContextUtil.getUsername()));
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean delete(Long id) {
        try {
            Personal personal = personalRepository.findOne(id);
            personalRepository.delete(personal);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Personal> findAll() {
        return StreamSupport.stream(personalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}



