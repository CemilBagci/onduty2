package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.TaskMessage;
import com.project.yasar.onduty.onduty.repository.TaskMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("taskMessageService")
@Transactional(readOnly = true)
public class TaskMessageServiceImpl implements TaskMessageService {
    @Autowired
    TaskMessageRepository taskMessageRepository;


    @Override
    @Transactional(readOnly = false)
    public TaskMessage createTaskMessage(TaskMessage taskMessage) {
        return taskMessageRepository.save(taskMessage);  
    }

}



