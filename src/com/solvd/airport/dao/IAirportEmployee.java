package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportEmployee;
import java.util.List;

public interface IAirportEmployee {

    AirportEmployee getByID(Long id);

    List<AirportEmployee> getAll();

    void save(AirportEmployee value);

    void delete(Long id);

    void update(AirportEmployee value);

}
