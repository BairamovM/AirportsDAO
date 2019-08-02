package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportEmployee;
import java.util.List;

public interface IAirportEmployee extends DAO <AirportEmployee> {

    AirportEmployee getByID(Long id);

    AirportEmployee getAll();

    AirportEmployee save(AirportEmployee value);

    void delete(Long id);

    void update(AirportEmployee value);

}
