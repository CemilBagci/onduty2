package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
	
	Task createTask(Task task);
	Task findTaskByTaskName(String name);
	String  getAssignerpersonal(String assignerpersonal);
	Task get(Long taskId);
	
	

	
	
	
}
