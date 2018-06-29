package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Department> departments = new ArrayList<Department>();
    
    @JoinColumn(name="project_id")
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Project> projects = new ArrayList<Project>();
    
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    
    public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
 
    public Personal(User user, List<Department> departments, List<Project> projects ) {
        this.user = user;
        this.departments = departments;
        this.projects = projects;
    }

    public Personal() {
    }

    public long getId() {
        return id;
    }

   
	public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return this.getUser().getName() + " " + this.getUser().getSurname();
    }
}
