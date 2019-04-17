package com.team5.spatial.soil.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;

@Entity
@Table(name = "soil")
public class SoilData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OGR_FID")
    private int id;

    @Column(name = "sqkm")
    private double sqkm;

    @JsonIgnore
    @Column(name = "SHAPE")
    private Geometry shape;

    public double getSqkm() {
        return sqkm;
    }

    public void setSqkm(double sqkm) {
        this.sqkm = sqkm;
    }
//    @Column(name = "country")
//    private String name;

    public SoilData(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Geometry getShape() {
        return shape;
    }

    public void setShape(Geometry shape) {
        this.shape = shape;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
