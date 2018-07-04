package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.REFRESH)
    private Set<Project> projects = new HashSet<>();
    
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    
    public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
 
    public Personal(User user, List<Department> departments, Set<Project> projects ) {
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
