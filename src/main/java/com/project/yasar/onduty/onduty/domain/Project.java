package com.project.yasar.onduty.onduty.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.DATE)
    @Column
    private Date starttime;

    @DateTimeFormat(pattern = "dd.MM.yyyy") // This is for bind Date with @ModelAttribute
    @Temporal(TemporalType.DATE)
    @Column
    private Date enddate;
    
    @Enumerated(EnumType.ORDINAL)
    private ProjectState projectstate;
    
    @Enumerated(EnumType.ORDINAL)
    private StateType statetype;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<Task>();

    

    public Project(String name, Date starttime, Date enddate, ProjectState projectstate, StateType statetype, List<Personal> personals, List<Task> tasks) {
        super();
        this.name = name;
        this.starttime = starttime;
        this.enddate = enddate;
        this.projectstate = projectstate;
        this.statetype = statetype;
        this.tasks = tasks;
    }


	public Project() {

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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public ProjectState getProjectstate() {
        return projectstate;
    }

    public void setProjectstate(ProjectState projectstate) {
        this.projectstate = projectstate;
    }

    public StateType getStatetype() {
        return statetype;
    }

    public void setStatetype(StateType statetype) {
        this.statetype = statetype;
    }

	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
