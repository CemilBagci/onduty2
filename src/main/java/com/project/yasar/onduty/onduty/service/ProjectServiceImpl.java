package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.repository.ProjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("projectService")
@Transactional(readOnly = true)
public class ProjectServiceImpl implements 	ProjectService {
    @Autowired
    ProjectRepository projectRepository;



    @Transactional(readOnly = false)
    @Override
    public Project createProject(Project projects) {
        return projectRepository.save(projects);
    }

    @Override
    public Project findProjectByProjectNameEquals(String name) {
        return projectRepository.findProjectByNameEquals(name);
    }

//	@Override
//	public List<Task> findTaskByProject(String project) {
//		return projectRepository.findTaskByProject(project);
//	}
//    
    
}

