package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "app_right")
public class Right {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private State state;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Role> roles = new ArrayList<Role>();

    public Right(String name, State state, List<Role> roles) {
        this.name = name;
        this.state = state;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Right() {
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
