package com.project.yasar.onduty.onduty.domain;

import org.springframework.format.annotation.DateTimeFormat;

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
    private String description;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private TaskStateType taskstatetype;
    
    @Enumerated(EnumType.ORDINAL)
    private StateTask  statetask;
    
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.DETACH)
    private Personal assignerPersonal;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Personal> assigneePersonals;

  

	@Column
    @Enumerated(EnumType.ORDINAL)
    private TaskPriority taskpriority;

    @JoinColumn( nullable = false)
    @ManyToOne(cascade = CascadeType.DETACH)
    private Project project;


    @DateTimeFormat(pattern = "dd.MM.yyyy") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.DATE)
    @Column
    private Date taskstartdate;

    @DateTimeFormat(pattern = "dd.MM.yyyy") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.DATE)
    @Column
    private Date taskenddate;


    @JoinColumn
    @OneToMany( cascade = CascadeType.ALL)
    private List<TaskMessage> taskMessages;

    public Task(String name, TaskStateType taskstatetype, StateTask statetask, Personal assignerPersonal, List<Personal> assigneePersonals, TaskPriority taskpriority, Date taskstartdate, Date taskenddate, Project project) {
        this.name = name;
        this.taskstatetype = taskstatetype;
        this.statetask = statetask;
        this.assignerPersonal = assignerPersonal;
        this.assigneePersonals = assigneePersonals;
        this.taskpriority = taskpriority;
        this.taskstartdate = taskstartdate;
        this.taskenddate = taskenddate;
        this.project = project;
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

    public Personal getAssignerPersonal() {
        return assignerPersonal;
    }

    public void setAssignerPersonal(Personal assignerPersonal) {
        this.assignerPersonal = assignerPersonal;
    }

    public List<Personal> getAssigneePersonals() {
        return assigneePersonals;
    }

    public void setAssigneePersonals(List<Personal> assigneePersonals) {
        this.assigneePersonals = assigneePersonals;
    }

    public TaskPriority getTaskpriority() {
        return taskpriority;
    }

    public void setTaskpriority(TaskPriority taskpriority) {
        this.taskpriority = taskpriority;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


	public StateTask getStatetask() {
		return statetask;
	}


	public void setStatetask(StateTask statetask) {
		this.statetask = statetask;
	}

    public List<TaskMessage> getTaskMessages() {
        return taskMessages;
    }

    public void setTaskMessages(List<TaskMessage> taskMessages) {
        this.taskMessages = taskMessages;
    }
}

