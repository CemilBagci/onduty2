package com.project.yasar.onduty.onduty.domain;
import javax.persistence.*;

@Entity
public class Credential{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.DETACH)
    private User user;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private State state;
    public Credential(User user, String username, String password, UserType userType) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Credential() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
