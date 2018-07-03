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
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.DETACH)
    private Personal personal;
    
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.DETACH)
    private Task task;

    public TaskMessage(String content, Date enrtyDate, Personal personal, Task task) {
        this.content = content;
        this.enrtyDate = enrtyDate;
        this.personal = personal;
        this.task = task;
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

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
