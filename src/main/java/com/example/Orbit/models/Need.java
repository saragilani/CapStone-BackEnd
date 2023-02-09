package com.example.Orbit.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "needs")
public class Need {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "need_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "completed")
    private Boolean completed;

    @JsonIgnoreProperties("needs")
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "caree_id")
    Caree caree;

    public Need(String name, String description, Boolean completed, Caree caree){
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.caree = caree;
        this.user = null;
    }

    public Need(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Caree getCaree() {
        return caree;
    }

    public void setCaree(Caree caree) {
        this.caree = caree;
    }
}
