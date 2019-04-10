package com.zakobah.spatial.controllers;

import com.zakobah.spatial.DoublePoint;
import com.zakobah.spatial.models.Shape;
import org.geolatte.geom.codec.Wkb;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.Query;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/map")
public class control {

    private SessionFactory sessionFactory;

    @Autowired
    public control(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @PostMapping("/getByCoords")
    public Coordinate[] getShape(@RequestBody DoublePoint point){
        try (Session session = sessionFactory.openSession()) {
            String sql = "SELECT * from shapes as s where contains(s.SHAPE,Point("+point.getX()+","+point.getY()+"));";
            NativeQuery query = session.createNativeQuery(sql,Shape.class);
            return ((Shape)query.getSingleResult()).getShape().getCoordinates();
        }
    }
}
