package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personalRepository")

public interface PersonalRepository extends CrudRepository<Personal,Long> {
	
	 Personal findPersonalByUser(User user);
	 Personal findPersonalByGroups(List<Group> groups);
	 Personal findPersonalByDepartments(Department department);
  
}
