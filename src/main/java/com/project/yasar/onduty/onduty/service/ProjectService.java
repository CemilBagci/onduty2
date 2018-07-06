package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface ProjectService {
    Project createProject(Project projects);
    Project findProjectByProjectNameEquals(String name);
//	List<Task> findTaskByProject(String project);
    List<Project> findAll();
    Project get(Long id);
    Boolean delete(Long id);
    List<Project> findProjectsByPersonalsContains(Personal personal);
}


// project groupla aynı formda yapıldı *melisa