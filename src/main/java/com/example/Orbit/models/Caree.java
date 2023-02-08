package com.example.Orbit.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "carees")
public class Caree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caree_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name="age")
    private int age;

    @Column (name = "bio")
    private String bio;

    @Column (name = "uniqueCode")
    private String uniqueCode;

    @JsonIgnoreProperties("carees")
    @OneToMany(mappedBy = "carees")
    private List<Need> needsList;

    public Caree(String name, int age, String bio, String uniqueCode){
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.uniqueCode = uniqueCode;
        this.needsList = new ArrayList<>();
    }

    public Caree(){}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public List<Need> getNeedsList() {
        return needsList;
    }

    public void setNeedsList(List<Need> needsList) {
        this.needsList = needsList;
    }
}
