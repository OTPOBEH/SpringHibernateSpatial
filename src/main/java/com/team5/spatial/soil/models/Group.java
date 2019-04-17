package com.team5.spatial.soil.models;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private int id;

    @Column(name = "group")
    private String group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
