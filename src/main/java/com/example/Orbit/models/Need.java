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

}
