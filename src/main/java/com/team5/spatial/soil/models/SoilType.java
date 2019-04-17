package com.team5.spatial.soil.models;

import javax.persistence.*;

@Entity
@Table(name = "soil_types")
public class SoilType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domsoi")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @OneToOne
    @JoinColumn(name = "id_characteristic")
    private Characteristic characteristic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
