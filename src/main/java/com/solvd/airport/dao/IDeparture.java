package com.solvd.airport.dao;

import com.solvd.airport.entity.Departure;
import java.util.List;

public interface IDeparture extends DAO <Departure> {

    Departure getByID(Long id);

    Departure getAll();

    Departure save(Departure value);

    void delete(Long id);

    void update(Departure value);

}
