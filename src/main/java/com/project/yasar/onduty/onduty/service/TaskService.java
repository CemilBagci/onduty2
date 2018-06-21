package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {
	Task createTask(Task task);
	Task findTaskByNameEquals(String name);
	String  getAssignerpersonal(String assignerpersonal);
	Date showTaskEndDate(Date taskenddate);
	Date showTaskStartDate(Date taskstartdate);
	Integer showTaskPriority(Integer taskpriority);

	
	
}
