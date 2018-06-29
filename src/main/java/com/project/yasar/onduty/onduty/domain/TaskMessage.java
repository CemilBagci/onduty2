package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TaskMessage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String content;
    @Column
    private Date enrtyDate;
    
    @JoinColumn(name = "personal_id")
    @OneToMany(cascade = CascadeType.DETACH)
    private List<Personal> personals = new ArrayList<Personal>();
    
    
    @JoinColumn(name = "task_id")
    @ManyToOne(cascade = CascadeType.DETACH)
    private Task task;

    public TaskMessage(String content, Date enrtyDate, List<Personal> personals, Task task) {
        this.content = content;
        this.enrtyDate = enrtyDate;
        this.personals = personals;
        this.task = task;
    }

    public TaskMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEnrtyDate() {
        return enrtyDate;
    }

    public void setEnrtyDate(Date enrtyDate) {
        this.enrtyDate = enrtyDate;
    }

    public List<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personal> personals) {
        this.personals = personals;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
