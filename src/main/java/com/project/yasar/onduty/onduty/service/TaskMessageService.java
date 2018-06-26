package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.TaskMessage;
import org.springframework.stereotype.Service;

@Service
public interface TaskMessageService {
	TaskMessage createTaskMessage(TaskMessage taskMessage);
	

	
	
}
