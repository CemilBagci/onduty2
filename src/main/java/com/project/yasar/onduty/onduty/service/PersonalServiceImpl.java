package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public Personal findPersonalById(String id) {
        return personalRepository.findPersonalById(id);
    }


}



