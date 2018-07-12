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
    private Date sendDate;
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.DETACH)
    private Personal personal;

    public TaskMessage() {
    }

    public TaskMessage(String content, Date sendDate, Personal personal) {
        this.content = content;
        this.sendDate = sendDate;
        this.personal = personal;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

}
