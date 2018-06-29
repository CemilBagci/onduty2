package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalService {
	Personal createPersonal(Personal personal); //+
	Personal updatePersonal(Personal personal); //+
	Personal findPersonalByUser(User user);  //+ kullan diğerlerinde?
	// -  Personal findPersonalByGroups(List<Group> groups); // bu silinecek
	Personal getCurrentPersonal(); // +

}
