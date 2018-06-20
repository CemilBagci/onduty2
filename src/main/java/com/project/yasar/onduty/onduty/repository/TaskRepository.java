package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("taskRepository")
public interface TaskRepository extends CrudRepository<Task,Long> {
			Task findTaskByTaskName(String Task);
}