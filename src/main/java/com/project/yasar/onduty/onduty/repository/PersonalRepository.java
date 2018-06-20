package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Personal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("personalRepository")

public interface PersonalRepository extends CrudRepository<Personal,Long> {
	
	 Personal findPersonalById(String id);
  
}
