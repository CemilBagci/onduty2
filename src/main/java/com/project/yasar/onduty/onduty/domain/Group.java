package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "app_group")
public class Group {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String groupName;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Personal> personals = new ArrayList<Personal>();

    public List<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personal> personals) {
        this.personals = personals;
    }

    public Group(String groupName, List<Personal> personals) {
        this.groupName = groupName;
        this.personals = personals;
    }

    public Group() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
