package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findTaskByNameEquals(String name) {
        return taskRepository.findTaskByNameEquals(name);
    }

    @Override
    public Task getAssignerpersonal(String assignerpersonal) {
        return null;
    }
}



