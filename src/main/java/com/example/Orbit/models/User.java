package com.example.Orbit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="emailAddress")
    private String emailAddress;

    @Column(name="location")
    private String location;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Need> toDoList;

    @ManyToMany
    @JoinTable(
            name="authorised_users",
            joinColumns = @JoinColumn(name = "caree_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Caree> carees;

    //
    public User(String name, String password, String emailAddress, String location){
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.location = location;
        this.toDoList = new ArrayList<>();
        this.carees = new ArrayList<>();
    }
    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Need> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<Need> toDoList) {
        this.toDoList = toDoList;
    }

    public List<Caree> getCarees() {
        return carees;
    }

    public void setCarees(List<Caree> carees) {
        this.carees = carees;
    }
}
