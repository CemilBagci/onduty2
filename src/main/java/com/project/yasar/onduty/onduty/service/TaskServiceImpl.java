package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("taskService")
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;


    @Override
    @Transactional(readOnly = false)
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findTaskByNameEquals(String name) {
        return taskRepository.findTaskByNameEquals(name);
    }

    @Override
    public String getAssignerpersonal(String assignerpersonal) {
        return null;
    }
    
    @Override
    public Date showTaskEndDate(Date taskenddate) {
    	return  null;
    }
    
    @Override
    public Date showTaskStartDate(Date taskstartdate) {
    	return  null;
    }
    
    @Override
    public Integer showTaskPriority(Integer taskpriority) {
    	return null;
    	
    }

}



