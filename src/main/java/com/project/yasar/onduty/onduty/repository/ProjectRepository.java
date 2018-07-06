package com.project.yasar.onduty.onduty.repository;


import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("projectRepository")

public interface ProjectRepository extends CrudRepository<Project,Long> {
   
	Project findProjectByNameEquals(String name);
	List<Project> findProjectsByPersonalsContains(Personal personal);
//	List<Task> findTaskByProject(String project);
	
	

}


//grupla benzer yapıldı * melisa