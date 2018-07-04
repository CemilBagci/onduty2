package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Project;
import com.project.yasar.onduty.onduty.domain.Task;
import com.project.yasar.onduty.onduty.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<Project> findAll() {
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Project get(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean delete(Long id) {
        try {
            Project project = projectRepository.findOne(id);
            projectRepository.delete(project);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    
}

