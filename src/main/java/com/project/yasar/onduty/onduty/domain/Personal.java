package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personal {
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
       private long id;
    @JoinColumn
    @OneToOne(cascade = CascadeType.DETACH)
      private User user;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Task> tasks = new ArrayList<Task>();


    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Group> groups = new ArrayList<Group>();

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Department> departments = new ArrayList<Department>();


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Personal(User user, List<Task> tasks, List<Group> groups, List<Department> departments) {
        this.user = user;
        this.tasks = tasks;
        this.groups = groups;
        this.departments = departments;
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
}
