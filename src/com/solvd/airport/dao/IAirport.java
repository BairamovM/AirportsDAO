package com.solvd.airport.dao;

import com.solvd.airport.entity.Airport;
import java.util.List;

public interface IAirport extends DAO <Airport> {

    Airport getByID(Long id);

    List<Airport> getAll();

    void save(Airport value);

    void delete(Long id);

    void update(Airport value);

}
