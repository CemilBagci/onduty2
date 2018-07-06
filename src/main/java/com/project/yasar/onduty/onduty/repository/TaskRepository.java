package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.domain.TaskPriority;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("taskRepository")
public interface TaskRepository extends CrudRepository<Task, Long> {
	
    Task findTaskByName(String name);

    LinkedList<Task> findByAssignerPersonalOrderByIdAsc(Personal personal);

}
