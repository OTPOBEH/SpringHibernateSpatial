package com.team5.spatial.soil.controllers;

import com.team5.spatial.soil.models.Point;
import com.team5.spatial.soil.models.SoilData;
import com.team5.spatial.soil.models.SoilDataDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soil")
public class SoilController {

    private SessionFactory sessionFactory;

    @Autowired
    public SoilController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @PostMapping("/getByCoords")
    public SoilDataDTO getShape(@RequestBody Point point){
        try (Session session = sessionFactory.openSession()) {
            String sql = String.format("SELECT * from soil as s where contains(s.SHAPE,Point(%f,%f));",point.getX(),point.getY());
            NativeQuery query = session.createNativeQuery(sql, SoilData.class);
            SoilData soilData = (SoilData)query.getSingleResult();

            SoilDataDTO result = new SoilDataDTO();
            result.setPolygon(soilData.getShape().toString());

            result.setSqKm(soilData.getSqkm());

            return result;
        }
    }
}
