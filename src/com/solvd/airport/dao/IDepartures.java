package com.solvd.airport.dao;

import com.solvd.airport.entity.Departures;
import java.util.List;

public interface IDepartures {

    Departures getByID(Long id);

    List<Departures> getAll();

    void save(Departures value);

    void delete(Long id);

    void update(Departures value);

}
