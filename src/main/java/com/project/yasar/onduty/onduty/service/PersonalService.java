package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface PersonalService {
	Personal createPersonal(Personal personal);
	Personal findPersonalByUser(User user);

}
