package com.solvd.airport.dao;

import com.solvd.airport.entity.Departure;
import java.util.List;

public interface IDeparture {

    Departure getByID(Long id);

    List<Departure> getAll();

    void save(Departure value);

    void delete(Long id);

    void update(Departure value);

}
