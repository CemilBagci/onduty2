package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {

	Task createTask(Task task);

	Task findTaskByTaskName(String name);
	
	String  getAssignerpersonal(String assignerpersonal);
	Task get(Long id);
	
	


   
	
	

}
