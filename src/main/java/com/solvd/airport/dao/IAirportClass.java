package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportClass;
import java.util.List;

public interface IAirportClass extends DAO <AirportClass> {

    AirportClass getByID(Long id);

    List<AirportClass> getAll();

    AirportClass save(AirportClass value);

    void delete(Long id);

    void update(AirportClass value);

}
