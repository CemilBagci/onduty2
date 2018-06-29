package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
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
    public Task findTaskByTaskName(String name) {
        return taskRepository.findTaskByName(name);
    }

    @Override
    public String getAssignerpersonal(String assignerpersonal) {
        return null;
    }
    


	@Override
	public Task get(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findOne(id);
	}
    


}



