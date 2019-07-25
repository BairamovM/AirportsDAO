package com.solvd.airport.dao;

import com.solvd.airport.entity.Passengers;
import java.util.List;

public interface IPassengers {

    Passengers getByID(Long id);

    List<Passengers> getAll();

    void save(Passengers value);

    void delete(Long id);

    void update(Passengers value);

}
