package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.TaskMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskMessageService {
	TaskMessage createTaskMessage(TaskMessage taskMessage);
}
