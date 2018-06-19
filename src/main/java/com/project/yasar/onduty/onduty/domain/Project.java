package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.Date;

//foreign key yok

@Entity
public class Project {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	 @Column
	    private String name;
	 @Column
	    private Date starttime;
	 @Column
	    private Date enddate;
	 @Enumerated(EnumType.ORDINAL)
	    private ProjectState projectstate;
	 @Enumerated(EnumType.ORDINAL)
	    private StateType statetype;
	public Project(String name, Date starttime, Date enddate, ProjectState projectstate, StateType statetype) {
		super();
		this.name = name;
		this.starttime = starttime;
		this.enddate = enddate;
		this.projectstate = projectstate;
		this.statetype = statetype;
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
	
	
	
}
