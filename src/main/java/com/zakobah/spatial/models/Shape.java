package com.zakobah.spatial.models;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;

@Entity
@Table(name = "shapes")
public class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OGR_FID")
    private int id;

    @Column(name = "shape")
    private Geometry shape;

    @Column(name = "state_name")
    private String name;

    public Shape(){}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
