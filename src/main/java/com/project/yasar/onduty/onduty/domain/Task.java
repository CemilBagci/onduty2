package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column

    @Enumerated(EnumType.ORDINAL)
    private TaskStateType taskstatetype;

    @JoinColumn(name = "personal_id")
    @ManyToOne(cascade = CascadeType.DETACH)
    private Personal assignerpersonal;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private TaskPriority taskpriority;

    @JoinColumn(name = "project_id")
    @ManyToOne(cascade = CascadeType.DETACH)
    private Project project;

    
    @Column
    private Date taskstartdate;
    @Column
    private Date taskenddate;

    public Task(String name, TaskStateType taskstatetype, Personal assignerpersonal, TaskPriority taskpriority, Project project,Date taskstartdate, Date taskenddate) {
        this.name = name;
        this.taskstatetype = taskstatetype;
        this.assignerpersonal = assignerpersonal;
        this.taskpriority = taskpriority;
        this.project = project;
  
        this.taskstartdate = taskstartdate;
        this.taskenddate = taskenddate;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStateType getTaskstatetype() {
        return taskstatetype;
    }

    public void setTaskstatetype(TaskStateType taskstatetype) {
        this.taskstatetype = taskstatetype;
    }

    public Personal getAssignerpersonal() {
        return assignerpersonal;
    }

    public void setAssignerpersonal(Personal assignerpersonal) {
        this.assignerpersonal = assignerpersonal;
    }

    public TaskPriority getTaskpriority() {
        return taskpriority;
    }

    public void setTaskpriority(TaskPriority taskpriority) {
        this.taskpriority = taskpriority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getTaskstartdate() {
        return taskstartdate;
    }

    public void setTaskstartdate(Date taskstartdate) {
        this.taskstartdate = taskstartdate;
    }

    public Date getTaskenddate() {
        return taskenddate;
    }

    public void setTaskenddate(Date taskenddate) {
        this.taskenddate = taskenddate;
    }
}

