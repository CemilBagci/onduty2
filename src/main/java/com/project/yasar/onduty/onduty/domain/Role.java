package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "app_role")
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String roleName;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private State state;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Right> rights = new ArrayList<Right>();

    public Role(String roleName, State state, List<Right> rights) {
        this.roleName = roleName;
        this.state = state;
        this.rights = rights;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
